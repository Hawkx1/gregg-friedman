package views;
import java.util.Scanner;

public class MainMenu extends View{

    public MainMenu(Scanner scanner) {
        super("Main Menu", scanner);
    }

    @Override
    public void renderView() {
        System.out.println("===MAIN MENU===\nEnter selection:\n\n1) Register an Account\n2) Login\n3) Quit");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                viewManager.navigate("ViewRegisterAccount");
                return;
            case "2":
                viewManager.navigate("LoginView");
                return;
            case "3":
                viewManager.setRunning(false);
                break;
            default:
                System.out.println("Please select a valid number (numeric values only)");
        }
    }
}
