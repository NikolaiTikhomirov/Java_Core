package market;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BasketsList<User, T> implements Serializable, Iterable<T>{
    private HashMap<User, Basket> basketsList;

    public BasketsList() {
        basketsList = new HashMap<User, Basket>();
    }

    public void addBasket(User user, Basket basket){
        if (basketsList.containsKey(user)){
            basketsList.replace(user, basket);
        }
        else{
            basketsList.put(user, basket);
        }
    }

    public Basket order (User user) {
        return basketsList.remove(user);
    }

    public Boolean contains(User user){
        return basketsList.containsKey(user);
    }

    public Basket getBasket(User user) {
        return basketsList.get(user);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        Integer count = 1;
        for (Map.Entry<User, Basket> basket : basketsList.entrySet()) {
            stringBuilder.append(count + ". ");
            stringBuilder.append(basket.getKey() + " ");
            stringBuilder.append(basket.getValue().toString());
            stringBuilder.append("\n");
            count++;
        }
        return (String) stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return ((Iterable<T>) basketsList).iterator();
    }
}
