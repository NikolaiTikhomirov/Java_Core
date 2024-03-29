package market.view.commands;

import market.view.View;

public class GetOrdersList implements Command {
    private View view;

    public GetOrdersList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть список заказов";
    }

    @Override
    public void execute() {
        view.getOrdersList();
    }
}
