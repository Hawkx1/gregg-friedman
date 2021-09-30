package views;

import DAO.LoginDAO;
import Utilities.ViewManager;

import java.util.Scanner;

public class ViewRegisterAccount extends View{

    public ViewRegisterAccount(Scanner scanner) {
        super("ViewRegisterAccount", scanner);
    }

    @Override
    public void renderView() {
        LoginDAO dao = new LoginDAO(viewManager.getKahn());
        String username;
        String password;
        String firstName;
        String lastName;
        double OpeningBalance;

        System.out.println("========== Register New Account: ==========");
        System.out.println("Welcome, Please enter your First Name:");
        firstName = scanner.nextLine();
        System.out.println("Please enter your Last Name:");
        lastName = scanner.nextLine();
        System.out.println("Please enter your username:");
        username = scanner.nextLine();
        System.out.println("Please enter your password:");
        password = scanner.nextLine();
        System.out.println("Please enter your opening balance:");
        OpeningBalance = scanner.nextDouble();
        dao.RegisterAccount(firstName, lastName, username, password, OpeningBalance);
        System.out.println("Account Successfully Created");

        viewManager.navigate("MainMenu");

    }
}
