package es.cuesta.myapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class ProductDetailsActivity extends Activity {

    public boolean isNetworkAvaliable() {
        ConnectivityManager CManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo NInfo = CManager.getActiveNetworkInfo();
        if (NInfo != null && NInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetails);



        int productIndex = getIntent().getExtras().getInt(
                ShoppingCartHelper.PRODUCT_INDEX);
        final Product selectedProduct;

        if(getIntent().hasExtra("Catalog")){
            List<Product> catalog = ShoppingCartHelper.getCatalog(getResources());
            selectedProduct = catalog.get(productIndex);
        }else{

            List<Product> shpCart = ShoppingCartHelper.getCartList();
            selectedProduct = shpCart.get(productIndex);
        }


        // Set the proper image and text
        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
        productImageView.setImageDrawable(selectedProduct.productImage);
        TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
        productTitleTextView.setText(selectedProduct.title);
        TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
        productDetailsTextView.setText(selectedProduct.description);

        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewProductPrice);
        productPriceTextView.setText(selectedProduct.price + "€");



        TextView textViewMax = (TextView) findViewById(R.id.textViewMax);

        // Update the current quantity in the cart
        TextView textViewCurrentQuantity = (TextView) findViewById(R.id.textViewCurrentlyInCart);
        textViewCurrentQuantity.setText("Ya en el carrito: "
                + ShoppingCartHelper.getProductQuantity(selectedProduct) + " Máximo:");

        // Save a reference to the quantity edit text
        final EditText editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);

        if(isNetworkAvaliable()){
            new LongOperation().execute(selectedProduct.title);

            //selectedProduct.stock = textViewMax.getText().toString();

        }else if(Integer.parseInt(selectedProduct.stock) != -1){
            //decir mediante toast q se pueden consultar los stocks pero no realizar pedidos sin internet
            textViewMax.setText(selectedProduct.stock);
            editTextQuantity.setFilters(new InputFilter[]{new InputFilterMinMax("0", selectedProduct.stock)});

        }else{
            //decir mediante toast que no se puede acceder por internet (y no hay una carga anterior tpko)

        }





        Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
        addToCartButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // Check to see that a valid quantity was entered
                int quantity = 0;
                try {
                    quantity = Integer.parseInt(editTextQuantity.getText()
                            .toString());

                    if (quantity < 0) {
                        Toast.makeText(getBaseContext(),
                                "Introduce 0 o más",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(),
                            "Introduce un número válido",
                            Toast.LENGTH_SHORT).show();

                    return;
                }

                // If we make it here, a valid quantity was entered
                ShoppingCartHelper.setQuantity(selectedProduct, quantity);

                // Close the activity
                finish();
            }
        });



    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost("http://dssw-cuesta-t1.appspot.com/disponible");

                List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                pairs.add(new BasicNameValuePair("nombre",params[0]));
                post.setEntity(new UrlEncodedFormEntity(pairs));
                HttpResponse response = client.execute(post);

                HttpEntity entity = response.getEntity();

                BufferedReader buffer;

                //String responseString = EntityUtils.toString(entity, "UTF-8");

                buffer = new BufferedReader(new InputStreamReader(entity.getContent()), 2048);
                return buffer.readLine();


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if(result != null){
                TextView textViewCurrentMax = (TextView) findViewById(R.id.textViewMax);
                textViewCurrentMax.setText(result);

                final EditText editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);
                editTextQuantity.setFilters(new InputFilter[]{new InputFilterMinMax("0", result)});


                List<Product> catalog = ShoppingCartHelper.getCatalog(getResources());
                int productIndex = getIntent().getExtras().getInt(
                        ShoppingCartHelper.PRODUCT_INDEX);
                final Product selectedProduct = catalog.get(productIndex);

                selectedProduct.stock = textViewCurrentMax.getText().toString();
            }

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }


}