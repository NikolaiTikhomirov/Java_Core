package market.view.commands;

import market.view.View;

public class GetUsersList implements Command {
    private View view;

    public GetUsersList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть список пользователей";
    }

    @Override
    public void execute() {
        view.getUsersList();
    }
}
