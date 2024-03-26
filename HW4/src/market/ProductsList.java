package market;

import java.io.Serializable;
import java.util.Iterator;
import java.util.HashMap;

public class ProductsList <String, T> implements Serializable, Iterable<T>{
    private HashMap<String, Product> productsList;

    public ProductsList() {
        productsList = new HashMap<String, Product>();
    }

    public void addProduct (Product product){
        if (productsList.containsKey(product.getTitle())){
            product.setQuantity(product.getQuantity() + productsList.get(product.getTitle()).getQuantity());
            productsList.put((String) product.getTitle(), product);
        }
        else{
            productsList.put((String) product.getTitle(), product);
        }
    }

    public Boolean contains(Product product){
        return productsList.containsKey(product.getTitle());
    }

    public Product addProductInBasket (String title, int quantity){
        if (productsList.get(title) == null) return null;
        if (quantity < productsList.get(title).getQuantity()) {
            Product product = productsList.get(title);
            Product productToBasket = new Product((java.lang.String) title, product.getPrice(), quantity);
            product.setQuantity(product.getQuantity() - quantity);
            return productToBasket;
        }
        if (quantity == productsList.get(title).getQuantity()){
            return productsList.remove(title);
        }
        else return null;
    }

    public Product getProduct (String title){
        return productsList.get(title);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        Integer count = 1;
        for (Product product : productsList.values()) {
            stringBuilder.append(count + ". Title ");
            stringBuilder.append(product.getTitle());
            stringBuilder.append(", price ");
            stringBuilder.append(product.getPrice());
            stringBuilder.append(", quantity ");
            stringBuilder.append(product.getQuantity());
            stringBuilder.append("\n");
            count++;
        }
        return (String) stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return ((Iterable<T>) productsList).iterator();
    }

}
