package market.view.commands;

import market.view.View;

public class MakeOrder implements Command {
    private View view;

    public MakeOrder(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Оформить заказ";
    }

    @Override
    public void execute() {
        view.makeOrder();
    }
    
}
