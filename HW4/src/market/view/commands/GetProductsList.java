package market.view.commands;

import market.view.View;

public class GetProductsList implements Command {
    private View view;

    public GetProductsList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть список продуктов";
    }

    @Override
    public void execute() {
        view.getProductsList();
    }
}
