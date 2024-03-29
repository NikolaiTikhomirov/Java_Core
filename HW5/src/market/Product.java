package market;

import java.io.Serializable;

public class Product implements Serializable {

    private String title;
    private int price;
    private Integer quantity;

    public Product(String title, int price, Integer quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Товар{" +
                "Наименование='" + title + '\'' +
                ", Цена=" + price +
                ", Колличество=" + quantity +
                '}';
    }
}