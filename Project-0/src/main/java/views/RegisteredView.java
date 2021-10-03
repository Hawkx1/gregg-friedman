package views;

import DAO.AccountsDAO;
import Items.AccountItem;
import Utilities.MyArrayList;
import Utilities.PrintMyList;

import java.sql.SQLException;
import java.util.Scanner;

public class RegisteredView extends View{
    private static String fName;
    private static int account_id;
    private static int customer_id;
    AccountsDAO adao = new AccountsDAO();

    public RegisteredView() {
        super();
    }

    public RegisteredView(Scanner scanner) {
        super("Registered View", scanner);
    }

    @Override
    public void renderView() throws SQLException {
        boolean registered = true;
        double amount;
        boolean isExists;
        while(registered) {
            System.out.println("========== " + fName + "'s Page: ==========\n\n1) Create a bank account\n2) Deposit Funds to an " +
                    "account\n3) Withdraw funds from an account\n4) Display all account balances\n5) Return to Main Menu");
            String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        System.out.println("Enter an opening balance: ");
                        double balance = scanner.nextDouble();
                        scanner.nextLine();
                        adao.newAcct(customer_id, balance);
                        System.out.println("Bank Account Successfully Created");
                        break;
                    case "2":
                        System.out.println("Enter an account to deposit funds to: ");
                        account_id = scanner.nextInt();
                        scanner.nextLine();
                        isExists = adao.CheckAccountExists(account_id, customer_id);
                        if(isExists)
                            System.out.println("Enter the amount to deposit: ");
                        else
                            break;
                        amount = scanner.nextDouble();
                        scanner.nextLine();
                        adao.DepositFunds(account_id, amount);
                        break;
                    case "3":
                        System.out.println("Enter an account to deposit funds to: ");
                        account_id = scanner.nextInt();
                        scanner.nextLine();
                        isExists = adao.CheckAccountExists(account_id, customer_id);
                        if(isExists)
                            System.out.println("Enter the amount to withdraw: ");
                        else
                            break;
                        amount = scanner.nextDouble();
                        scanner.nextLine();
                        adao.WithdrawFunds(account_id, amount);
                        break;
                    case "4":
                        System.out.println("========== " + fName + "'s Page: ==========");
                        MyArrayList<AccountItem> acctList = new MyArrayList<>();
                        acctList = adao.getAccountsByUser(fName);

                        for(int i =0; i < acctList.getElementsInArray(); i++) {
                            PrintMyList.printList(acctList.get(i));
                        }
                        System.out.println("============================================");
                        break;
                    case "5":
                        viewManager.navigate("Main Menu");
                        viewManager.goToNextView();
                        break;
            }
        }
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public static void setAccount_id(int account_id) {
        RegisteredView.account_id = account_id;
    }

    public static void setCustomer_id(int customer_id) {
        RegisteredView.customer_id = customer_id;
    }
}
