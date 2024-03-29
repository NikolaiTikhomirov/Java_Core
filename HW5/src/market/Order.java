package market;

import java.io.Serializable;

public class Order implements Serializable {
    private static int count = 1;
    private int id;
    private User user;
    private Basket<String, Product> basket;
    private Double finalPrice;

    public Order(User user, Basket basket, Double finalPrice) {
        this.id = count;
        count++;
        this.user = user;
        this.basket = basket;
        this.finalPrice = finalPrice;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Заказ{" + "id " + id +
                ", пользователь=" + user.getName() +
                ", список покупок=" + basket.toString() +
                ", цена со скидкой=" + finalPrice +
                '}';
    }
}