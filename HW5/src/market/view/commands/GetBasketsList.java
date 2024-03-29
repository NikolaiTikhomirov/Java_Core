package market.view.commands;

import market.view.View;

public class GetBasketsList implements Command {
    private View view;

    public GetBasketsList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть список товаров из корзины";
    }

    @Override
    public void execute() {
        view.getBasketsList();
    }
}
