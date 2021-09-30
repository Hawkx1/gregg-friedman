import Utilities.ConnectionManager;
import Utilities.ViewManager;

import java.sql.Connection;

public class BankMain {

    public static void main(String[] args){

        ViewManager viewManager = ViewManager.getViewManager();
        Connection kahn = ConnectionManager.getConnection();

        while(viewManager.isRunning()) {

        }
    }
}