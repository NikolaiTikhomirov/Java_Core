package market;

import market.enums.Gender;
import market.exceptions.ProductNotFoundException;
import market.exceptions.QuantityIsNegativeException;
import market.exceptions.UserNotFoudException;
import market.fileHandler.Writable;

public class Market {

    private UsersList<String, User> usersList;
    private String usersListPath;
    private ProductsList<String, Product> productsList;
    private String productsListPath;
    private OrdersList<Integer, Order> ordersList;
    private String ordersListPath;
    private String basketsListPath;
    private BasketsList<User, Basket> basketsList;
    private Writable writable;


    public Market(Writable writable) {
        this.writable = writable;

        usersListPath = "src/market/db/usersListPath";
        usersList = (UsersList<String, User>) writable.read(usersListPath);
        productsListPath = "src/market/db/productsListPath";
        productsList = (ProductsList<String, Product>) writable.read(productsListPath);
        ordersListPath = "src/market/db/ordersListPath";
        ordersList = (OrdersList<Integer, Order>) writable.read(ordersListPath);
        basketsListPath = "src/market/db/basketsListPath";
        basketsList = (BasketsList<User, Basket>) writable.read(basketsListPath);

//        users = new ArrayList<>(List.of(
//                new User("Mary", 45, "11111", Gender.FEMALE),
//                new User("Bob", 26, "22222", Gender.MALE),
//                new User("Kate", 53, "33333", Gender.FEMALE),
//                new User("John", 40, "44444", Gender.MALE)
//        ));

//        productList = new ArrayList<>(List.of(
//                new Product("Milk", 89),
//                new Product("Bread", 26),
//                new Product("Cheese", 125)
//        ));

//        orders = new ArrayList<>();
    }

    public int createOrder(User user, Basket basket) throws UserNotFoudException {
        if (!usersList.contains(user)) throw new UserNotFoudException("user not found, " + user);
        Order order = new Order(user, basket);
        ordersList.addOrder(order);
        return order.getId();
    }

    public Basket addProductToBasket(User user, Product product, int quantity)
            throws ProductNotFoundException, QuantityIsNegativeException {
        if (!productsList.contains(product)) throw new ProductNotFoundException("product not found");
        if (quantity <= 0) throw new QuantityIsNegativeException("quantity of product is negative");
        if (quantity > product.getQuantity()) throw new QuantityIsNegativeException("not enough products");
        Basket basket;
        if (basketsList.contains(user)){
            basket = basketsList.getBasket(user);
        }
        else {
            basket = new Basket();
        }
        Product prod = productsList.addProductInBasket(product.getTitle(), quantity);
        basket.addProduct(prod, quantity);
        basketsList.addBasket(user, basket);
        return basket;
    }

    public void addProductInProductList(String title, int price, Integer quantity){
        Product product = new Product(title, price, quantity);
        productsList.addProduct(product);
    }

    public void addUser(String name, int age, String phone, Gender gender){
        User user = new User(name, age, phone, gender);
        usersList.addUser(user);
    }

    public void saveChanges(){
        writable.save(productsList, productsListPath);
        writable.save(usersList, usersListPath);
        writable.save(basketsList, basketsListPath);
        writable.save(ordersList, ordersListPath);
    }

    public BasketsList<User, Basket> getBasketsList() {
        return basketsList;
    }

    public UsersList<String, User> getUsersList() {
        return usersList;
    }

    public ProductsList<String, Product> getProductsList() {
        return productsList;
    }

    public OrdersList<Integer, Order> getOrdersList() {
        return ordersList;
    }
}
