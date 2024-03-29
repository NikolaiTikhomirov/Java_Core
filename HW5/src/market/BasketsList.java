package market;

import market.enums.Gender;
import market.enums.Holidays;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BasketsList<User, T> implements Serializable, Iterable<T>{
    private HashMap<User, Basket> basketsList;
    private Holidays holiday;
    private Date date;

    public BasketsList() {
        basketsList = new HashMap<User, Basket>();
        date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM");
        date.setDate(1);
        date.setMonth(0);
        java.lang.String str = dateFormat.format(date);
        switch (str) {
            case "1 января" -> holiday = Holidays.valueOf("NEW_YEAR");
            case "8 марта" -> holiday = Holidays.valueOf("MARCH_8");
            case "23 февраля" -> holiday = Holidays.valueOf("FEBRUARY_23");
            default -> holiday = Holidays.valueOf("NO_HOLIDAY");
        }
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

    public Double showFullPrice (User user){
        market.User usr = (market.User) user;
        Double finalPrice = Double.valueOf(getBasket(user).countFullPrice());
        System.out.println("Стоимость всех товаров в корзине: " + finalPrice);
        Gender gender = usr.getGender();
        if (holiday.equals(Holidays.MARCH_8) && gender.equals(Gender.FEMALE)){
            finalPrice = finalPrice * 0.85;
            System.out.println("Стоимость с учетом скидки на 8 марта: " + finalPrice);
        }
        if (holiday.equals(Holidays.FEBRUARY_23) && gender.equals(Gender.MALE)){
            finalPrice = finalPrice * 0.85;
            System.out.println("Стоимость с учетом скидки на 23 февраля: " + finalPrice);
        }
        if (holiday.equals(Holidays.NEW_YEAR)){
            finalPrice = finalPrice * 0.8;
            System.out.println("Стоимость с учетом скидки на 1 января: " + finalPrice);
        }
        return finalPrice;
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
