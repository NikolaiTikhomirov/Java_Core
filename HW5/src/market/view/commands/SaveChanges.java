package market.view.commands;

import market.view.View;

public class SaveChanges implements Command {
    private View view;

    public SaveChanges(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохранить изменения";
    }

    @Override
    public void execute() {
        view.saveChanges();
    }
    
}
