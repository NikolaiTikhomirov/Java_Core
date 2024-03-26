package market;

import market.fileHandler.FileHandler;
import market.view.Console;

public class Main {

    public static void main(String[] args) {
        FileHandler writable = new FileHandler();
        Market market = new Market(writable);
        Console view = new Console(market);
        view.start();
    }
}