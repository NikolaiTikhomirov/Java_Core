package market;

import java.io.Serializable;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

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
        for (Map.Entry<Integer, Order> order : ordersList.entrySet()) {
            stringBuilder.append(order.getKey() + ". " + order.getValue().toString());
            stringBuilder.append("\n");
        }
        return (String) stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return ((Iterable<T>) ordersList).iterator();
    }
}
