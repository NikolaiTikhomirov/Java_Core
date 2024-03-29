package market.view.commands;

import market.view.View;

public class AddUser implements Command {
    private View view;

    public AddUser(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить пользователя";
    }

    @Override
    public void execute() {
        view.addUser();
    }
}
