package views;

import Utilities.ViewManager;

import java.sql.SQLException;
import java.util.Scanner;

public abstract class View {
    protected Scanner scanner;
    protected String viewName;
    protected ViewManager viewManager;

    public View(String viewName, Scanner scanner) {
        this.scanner = scanner;
        this.viewName = viewName;
        this.viewManager = viewManager.getViewManager();
    }

    public String getViewName() {
        return viewName;
    }

    public abstract void renderView() throws SQLException;
    }
}
