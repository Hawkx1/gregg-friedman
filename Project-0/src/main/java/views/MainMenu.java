package views;

import Utilities.ViewManager;

import java.util.Scanner;

public class MainMenu extends View{

    public MainMenu(Scanner scanner) {
        super("MainMenu", scanner);
    }

    @Override
    public void renderView() {
        System.out.println("===MAIN MENU===\nEnter selection:\n\n1) Register an Account\n2) Login\nQ) Quit");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                viewManager.navigate("ViewRegisterAccount");
                return;
            case "2":
                viewManager.navigate("LoginView");
            case "Q":
            case "q":
                viewManager.setRunning(false);
                return;
        }
    }
}
