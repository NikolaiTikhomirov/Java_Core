package market.view.commands;

import market.view.View;

public class BackupDB implements Command {
    private View view;

    public BackupDB(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Создать резервную копию базы данных";
    }

    @Override
    public void execute() {
        view.backupDB();
    }
}
