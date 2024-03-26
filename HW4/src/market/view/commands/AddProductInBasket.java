package market.view.commands;

import market.view.View;

public class AddProductInBasket implements Command {
    private View view;

    public AddProductInBasket(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Положить товар в корзину";
    }

    @Override
    public void execute() {
        view.addProductInBasket();
    }
    
}
