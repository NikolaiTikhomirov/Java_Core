package market;

import java.io.Serializable;
import java.util.*;

public class Basket<String, T> implements Serializable, Iterable<T>{
    private HashMap<String, Product> basket;

    public Basket() {
        basket = new HashMap<String, Product>();
    }

    public void addProduct (Product product, Integer quantity){
        if (basket.containsKey(product.getTitle())){
            product.setQuantity(product.getQuantity() + quantity);
            basket.put((String) product.getTitle(), product);
        }
        else{
            basket.put((String) product.getTitle(), product);
        }
    }

    @Override
    public java.lang.String toString() {
        List list = new ArrayList<>();
        for (Product product : basket.values()) {
            list.add(product);
        }
        return "Корзина{" + list + "}" + " Общая стоимость: " + countFullPrice();
    }

    public Integer countFullPrice(){
        int res = 0;
        for (Product value : basket.values()) {
            res += value.getPrice() * value.getQuantity();
        }
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return ((Iterable<T>) basket).iterator();
    }
}
