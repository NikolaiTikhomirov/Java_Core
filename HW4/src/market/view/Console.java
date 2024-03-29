package market.view;

import market.*;
import market.enums.Gender;

import java.util.Scanner;

public class Console implements View{

    private static final String INPUT_ERROR = "Введенные данные некорректны, попробуйте еще раз";
    private Scanner scanner;
    private Boolean work;
    private MainMenu mainMenu;
    private Market market;


    public Console(Market market){
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        this.market = market;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Доброго времени суток");
        while (work) {
            printMenu();
            execute();
        }
    }

    @Override
    public void addProduct() {
        boolean addWork;
        addWork = true;
        root: while (addWork){
            try {
                System.out.println("Введите название товара");
                String name = scanner.nextLine();
                System.out.println("Введите стоимость товара");
                Integer price = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите количество товара");
                Integer quantity = Integer.parseInt(scanner.nextLine());
                market.addProductInProductList(name, price, quantity);
            } catch (Exception e) {
                System.out.println(INPUT_ERROR);
                continue root;
            }
            addWork = false;
        }
    }

    @Override
    public void addUser() {
        boolean addWork;
        addWork = true;
        root: while (addWork){
            try {
                System.out.println("Введите имя пользователя");
                String name = scanner.nextLine();
                System.out.println("Введите возраст пользователя");
                Integer age = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите номер телефона пользователя");
                String phone = scanner.nextLine();
                System.out.println("Введите пол пользователя (MALE или FEMALE)");
                Gender gender = Gender.valueOf(scanner.nextLine());
                market.addUser(name, age, phone, gender);
            } catch (Exception e) {
                System.out.println(INPUT_ERROR);
                continue root;
            }
            addWork = false;
        }
    }

    @Override
    public void getProductsList() {
        System.out.println(market.getProductsList().getInfo());
    }

    @Override
    public void getBasketsList() {
        System.out.println(market.getBasketsList().getInfo());
    }

    @Override
    public void getUsersList() {
        System.out.println(market.getUsersList().getInfo());
    }

    @Override
    public void addProductInBasket() {
        boolean addWork;
        addWork = true;
        root: while (addWork) {
            try {
                market.getProductsList().getInfo();
                System.out.println("Введите имя покупателя");
                String name = scanner.nextLine();
                System.out.println("Введите название товара, который хотите приобрести");
                String title = scanner.nextLine();
                System.out.println("Введите колличество приобретаемого товара");
                int quantity = Integer.parseInt(scanner.nextLine());
                User user = market.getUsersList().getUser(name);
                market.addProductToBasket(user, market.getProductsList().getProduct(title), quantity);
                market.getBasketsList().showFullPrice(user);
            } catch (Exception e) {
                System.out.println(INPUT_ERROR);
                e.printStackTrace();
                continue root;
            }
            addWork = false;
        }
    }

    @Override
    public void makeOrder() {
        boolean addWork;
        addWork = true;
        root: while (addWork) {
            try {
                System.out.println("Введите имя покупателя");
                String name = scanner.nextLine();
                User user = market.getUsersList().getUser(name);
                BasketsList basketsList = market.getBasketsList();
                Double finalPrice = basketsList.showFullPrice(user);
                System.out.println("Чтобы подтвердить покупку, напишите 'yes'");
                String confirm = scanner.nextLine();
                if (confirm.equals("yes")) {
                    market.makeOrder(user, basketsList.order(user), finalPrice);
                }
                else {
                    System.out.println(INPUT_ERROR);
                    continue root;
                }
            } catch (Exception e) {
                System.out.println(INPUT_ERROR);
                e.printStackTrace();
                continue root;
            }
            addWork = false;
        }
    }

    @Override
    public void getOrdersList() {
        System.out.println(market.getOrdersList().getInfo());
    }

    @Override
    public void finish() {
        System.out.println("До скорых встреч");
        scanner.close();
        work = false;
    }

    private void printMenu(){
        System.out.println(mainMenu.print());
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    @Override
    public void saveChanges() {
        market.saveChanges();
    }

}
