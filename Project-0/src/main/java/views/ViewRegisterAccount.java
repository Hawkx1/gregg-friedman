package views;

import DAO.LoginDAO;
import java.util.Scanner;

public class ViewRegisterAccount extends View{

    public ViewRegisterAccount(Scanner scanner) {
        super("ViewRegisterAccount", scanner);
    }

    @Override
    public void renderView() {
        LoginDAO dao = new LoginDAO(viewManager.getKahn());
        String selection;
        boolean invalid = true;
        boolean valid = true;
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
        valid = dao.RegisterAccount(firstName, lastName, username, password, OpeningBalance);
        scanner.nextLine();
        if(valid) {
            System.out.println("Login Account Successfully Created");

            System.out.println("What Would You Like To Do Next?: ");
            System.out.println("1) Return to Main Menu");
            System.out.println("2) Go to your account page");
            //If the user picks one or two the program will take them to either the Main Menu or their account page
            //otherwise it will ask them to pick either 1 or 2.
            while (invalid) {
                selection = scanner.nextLine();
                if (selection.equals("1")) {
                    viewManager.navigate("Main Menu");
                    invalid = false;
                } else if (selection.equals("2")) {
                    reg.setfName(firstName);
                    viewManager.navigate("Registered View");
                    invalid = false;
                } else {
                    System.out.println("Please select 1 or 2 (numeric values only)");
                    invalid = true;
                }
            }
        }
    }
}