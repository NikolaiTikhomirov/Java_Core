package market.view;

public interface View {
    void print(String text);
    void start();
    void addProduct();
    void addUser();
    void getProductsList();
    void addProductInBasket();
    void getBasketsList();
    void getUsersList();
    void makeOrder();
    void getOrdersList();
    void saveChanges();
    void finish();
}
