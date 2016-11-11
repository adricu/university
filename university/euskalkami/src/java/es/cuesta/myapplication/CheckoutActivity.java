package es.cuesta.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class CheckoutActivity extends ActionBarActivity {
    private static String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);

        total = Double.toString(getIntent().getDoubleExtra("Total",0.0))+"€";
        TextView viewTotal = (TextView) findViewById(R.id.total);
        viewTotal.append(total);

        Button viewCheckOut = (Button) findViewById(R.id.confirma);
        viewCheckOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(getIntent().getDoubleExtra("Total",0.0) != 0.0) {
                    EditText nombre = (EditText) findViewById(R.id.editName);
                    EditText email = (EditText) findViewById(R.id.editEmail);
                    EditText telefono = (EditText) findViewById(R.id.editPhone);
                    EditText direccion = (EditText) findViewById(R.id.editAddress);
                    EditText ciudad = (EditText) findViewById(R.id.editCity);


                    new LongOperation().execute(nombre.getText().toString(),
                            email.getText().toString(),
                            telefono.getText().toString(),
                            direccion.getText().toString(),
                            ciudad.getText().toString(),
                            total);

                    Toast.makeText(getBaseContext(),
                            "Pedido realizado correctamente",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(),
                            "No has seleccionado ningún producto",
                            Toast.LENGTH_SHORT).show();
                }



            }
        });



    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost("http://dssw-cuesta-t1.appspot.com/purchaseOrdered");
                    Iterator<Product> itr;
                    itr = ShoppingCartHelper.getCartList().iterator();

                    String products = new String();
                    Product p;

                    while(itr.hasNext()){
                        p = itr.next();
                        products = products + p.title+","+ShoppingCartHelper.getProductQuantity(p)+"-";
                    }


                    List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                    pairs.add(new BasicNameValuePair("nombre",params[0] ));
                    pairs.add(new BasicNameValuePair("email", params[1]));
                    pairs.add(new BasicNameValuePair("telefono", params[2]));
                    pairs.add(new BasicNameValuePair("direccion", params[3]));
                    pairs.add(new BasicNameValuePair("ciudad", params[4]));
                    pairs.add(new BasicNameValuePair("total", params[5]));
                    pairs.add(new BasicNameValuePair("pedido", products.substring(0,products.length()-1)));

                    post.setEntity(new UrlEncodedFormEntity(pairs));
                    HttpResponse response = client.execute(post);



                } catch (Exception e) {
                    e.printStackTrace();
                }

            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }


}
