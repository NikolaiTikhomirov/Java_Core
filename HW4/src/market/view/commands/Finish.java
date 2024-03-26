package market.view.commands;

import market.view.View;

public class Finish implements Command {
    private View view;

    public Finish(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Завершить работу";
    }

    @Override
    public void execute() {
        view.finish();
    }
}
