package market;

import java.io.Serializable;
import java.util.Iterator;
import java.util.HashMap;

public class OrdersList <String, T> implements Serializable, Iterable<T>{
    private HashMap<Integer, Order> ordersList;

    public OrdersList() {
        ordersList = new HashMap<Integer, Order>();
    }

    public void addOrder (Order order){
        ordersList.put(order.getId(), order);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        Integer count = 1;
        for (Order order : ordersList.values()) {
            stringBuilder.append(count + order.toString());
            stringBuilder.append("\n");
            count++;
        }
        return (String) stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return ((Iterable<T>) ordersList).iterator();
    }
}
