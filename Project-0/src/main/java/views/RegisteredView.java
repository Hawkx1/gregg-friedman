package views;

import DAO.AccountsDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class RegisteredView extends View{
    private static String fName;
    private static int account_id;
    AccountsDAO ac = new AccountsDAO();

    public RegisteredView() {
        super();
    }

    public RegisteredView(Scanner scanner) {
        super("Registered View", scanner);
    }

    @Override
    public void renderView() throws SQLException {
        System.out.println(fName);
        System.out.println(account_id);
        System.out.println("========== " + fName + "'s Page: ==========\n\n1) Create a bank account\n2) Deposit Funds to an " +
                "account\n3) Withdraw funds from an account\n4) Display all account balances\n5) Return to Main Menu");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                System.out.println("Enter an opening balance: ");
                double balance = scanner.nextDouble();
                scanner.nextLine();
                ac.newAcct(account_id, balance);
            case "2":
            case "3":
            case "4":
            case "5":
                viewManager.navigate("Main Menu");
                viewManager.goToNextView();

        }
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public static int getAccount_id() {
        return account_id;
    }

    public static void setAccount_id(int account_id) {
        RegisteredView.account_id = account_id;
    }
}
