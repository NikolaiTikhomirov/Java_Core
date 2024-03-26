package market.view.commands;

import market.view.View;

public class AddProduct implements Command {
    private View view;

    public AddProduct(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить продукт";
    }

    @Override
    public void execute() {
        view.addProduct();
    }
}
