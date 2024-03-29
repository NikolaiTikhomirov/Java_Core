package market.view;

import market.view.commands.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new AddProduct(view));
        commandList.add(new GetProductsList(view));
        commandList.add(new AddUser(view));
        commandList.add(new GetUsersList(view));
        commandList.add(new AddProductInBasket(view));
        commandList.add(new GetBasketsList(view));
        commandList.add(new MakeOrder(view));
        commandList.add(new GetOrdersList(view));
        commandList.add(new SaveChanges(view));
        commandList.add(new BackupApplication(view));
        commandList.add(new BackupDB(view));
        commandList.add(new Finish(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public void execute(int numCommand){
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }
}
