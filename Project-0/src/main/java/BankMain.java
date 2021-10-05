import Utilities.ConnectionManager;
import Utilities.ViewManager;
import java.sql.Connection;
import java.sql.SQLException;

public class BankMain {

    public static void main(String[] args){

        ViewManager viewManager = ViewManager.getViewManager();

        viewManager.navigate("Main Menu");
        while(viewManager.isRunning()) {
            try{
                viewManager.goToNextView();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}