package market;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;

public class UsersList <String, T> implements Serializable, Iterable<T>{
    private HashMap<String, User> usersList;

    public UsersList() {
        usersList = new HashMap<String, User>();
    }

    public void addUser (User user){
        usersList.put((String) user.getName(), user);
    }

    public Boolean contains(User user){
        return usersList.containsKey(user.getName());
    }

    public User getUser (String name){
        return usersList.get(name);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        Integer count = 1;
        for (User user : usersList.values()) {
            stringBuilder.append(count + ". Name ");
            stringBuilder.append(user.getName());
            stringBuilder.append(", age ");
            stringBuilder.append(user.getAge());
            stringBuilder.append(", gender ");
            stringBuilder.append(user.getGender());
            stringBuilder.append(", phone ");
            stringBuilder.append(user.getPhone());
            stringBuilder.append("\n");
            count++;
        }
        return (String) stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return ((Iterable<T>) usersList).iterator();
    }
}
