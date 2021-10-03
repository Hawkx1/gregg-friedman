package views;

import DAO.LoginDAO;
import Utilities.ViewManager;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewRegisterAccount extends View{

    public ViewRegisterAccount(Scanner scanner) {
        super("ViewRegisterAccount", scanner);
    }

    @Override
    public void renderView() {
        LoginDAO dao = new LoginDAO(viewManager.getKahn());
        int selection;
        boolean invalid = true;
        String username;
        String password;
        String firstName;
        String lastName;
        double OpeningBalance;
        RegisteredView reg = new RegisteredView(scanner);

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
        System.out.println("Login Account Successfully Created");
        scanner.nextLine();


        System.out.println("What Would You Like To Do Next?: ");
        System.out.println("1) Return to Main Menu");
        System.out.println("2) Go to your account page");
        selection = scanner.nextInt();
        scanner.nextLine();
        while(invalid)
            try {
                if(selection == 1) {
                    viewManager.navigate("Main Menu");
                    viewManager.goToNextView();
                    invalid = false;
                } else if (selection == 2) {
                    reg.setfName(firstName);
                    viewManager.navigate("Registered View");
                    viewManager.goToNextView();
                    invalid = false;
                }
                else {
                    System.out.println("Please select 1 or 2");
                    invalid = true;
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
