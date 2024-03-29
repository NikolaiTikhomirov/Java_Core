package market.fileHandler;

import market.BasketsList;
import market.OrdersList;
import market.ProductsList;
import market.UsersList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class FileHandler implements Writable{

    @Override
    public void save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Сохранить не удалось");
        }
    }

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            Serializable list;
            if (filePath.contains("users")){
                list = new UsersList<>();
            }
            else if (filePath.contains("products")){
                list = new ProductsList<>();
            }
            else if (filePath.contains("baskets")){
                list = new BasketsList<>();
            }
            else if (filePath.contains("orders")){
                list = new OrdersList<>();
            }
            else {
                list = new HashMap<>();
            }
            FileHandler writable = new FileHandler();
            writable.save(list, filePath);
            System.out.println("Создан новый список");
            return list;
        }
    }
}
