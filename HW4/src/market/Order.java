package market;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order implements Serializable {

    private static int count = 1;
    private int id;
    private User user;
    private Basket<String, Product> basket;

    public Order(User user, Basket basket) {
        this.id = count;
        count++;
        this.user = user;
        this.basket = basket;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        List list = new ArrayList<>();
        for (Product product : basket) {
            list.add(product);
        }
        return "Order{" + "id " + id +
                ", user=" + user.getName() +
                ", products=" + list +
                '}';
    }
}