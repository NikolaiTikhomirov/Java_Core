package market.view.commands;

import market.view.View;

public class BackupApplication implements Command {
    private View view;

    public BackupApplication(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Создать резервную копию файлов приложения";
    }

    @Override
    public void execute() {
        view.backupApplication();
    }
}
