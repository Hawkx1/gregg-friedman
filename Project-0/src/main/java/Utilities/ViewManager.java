package Utilities;

import views.LoginView;
import views.MainMenu;
import views.View;
import views.ViewRegisterAccount;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewManager {
    private static ViewManager viewManager;
    private static View nextView;
    private MyArrayList<View> viewList;
    private boolean running;
    private Connection kahn;
    private Scanner scanner;

    private ViewManager() {
        viewManager = this;
        running = true;
        kahn = ConnectionManager.getConnection();
        scanner = new Scanner(System.in);
        viewList = new MyArrayList<>();

        //set up views
        viewList.add(new MainMenu(scanner));
        viewList.add(new ViewRegisterAccount(scanner));
        viewList.add(new LoginView(scanner));
    }

    public static ViewManager getViewManager() {
        if(viewManager == null) {
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    public void navigate(String destination) {
        for(int i = 0; i < viewList.size(); i++) {
            if(viewList.equals(destination)) {
                nextView = viewList[i];
            }
        }
    }

    public void goToNextView() throws SQLException {
        nextView.renderView();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Connection getKahn() {
        return kahn;
    }
}
