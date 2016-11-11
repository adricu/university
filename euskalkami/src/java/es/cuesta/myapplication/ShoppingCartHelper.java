package es.cuesta.myapplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product("FC Barcelona", res.getDrawable(R.drawable.barcelona),
                    "Camiseta oficial del equipo de la Primera División Española", 50.00));
            catalog.add(new Product("Athletic Club", res
                    .getDrawable(R.drawable.athletic),
                    "Camiseta oficial del equipo de la Primera División Española", 60.00));
            catalog.add(new Product("Real Sociedad", res
                    .getDrawable(R.drawable.realsociedad),
                    "Camiseta oficial del equipo de la Primera División Española", 70.00));
            catalog.add(new Product("Real Madrid CF", res
                    .getDrawable(R.drawable.realmadrid),
                    "Camiseta oficial del equipo de la Primera División Española", 80.00));
        }

        return catalog;
    }

    public static void setQuantity(Product product, int quantity) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0) {
            if(curEntry != null)
                removeProduct(product);
            return;
        }

        // If a current cart entry doesn't exist, create one
        if(curEntry == null) {
            curEntry = new ShoppingCartEntry(product, quantity);
            cartMap.put(product, curEntry);
            return;
        }

        // Update the quantity
        curEntry.setQuantity(quantity);
    }

    public static int getProductQuantity(Product product) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        if(curEntry != null)
            return curEntry.getQuantity();

        return 0;
    }

    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet()) {
            cartList.add(p);
        }

        return cartList;
    }


}
