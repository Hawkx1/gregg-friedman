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
            System.out.println("========== " + fName + "'s Page: ==========\n\n1) Create a bank account\n" +
                    "2) Deposit Funds to an account\n3) Withdraw funds from an account\n4) Transfer funds from one " +
                    "account to another\n5) Display all account balances\n6) Return to Main Menu");
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
                        boolean success;
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
                        success = adao.DepositFunds(account_id, amount);
                        if (success)
                            System.out.println("Funds successfully deposited");
                        break;
                    case "3":
                        System.out.println("Enter an account to withdraw funds from: ");
                        account_id = scanner.nextInt();
                        scanner.nextLine();
                        isExists = adao.CheckAccountExists(account_id, customer_id);
                        if(isExists)
                            System.out.println("Enter the amount to withdraw: ");
                        else
                            break;
                        amount = scanner.nextDouble();
                        scanner.nextLine();
                        success = adao.WithdrawFunds(account_id, amount);
                        if (success)
                            System.out.println("Funds successfully withdrawn");
                        break;
                    case "4":
                        int acct_id1, acct_id2;

                        System.out.println("Enter account to transfer funds from: ");
                        acct_id1 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter account to transfer funds to: ");
                        acct_id2 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter amount to transfer: ");
                        amount = scanner.nextDouble();
                        scanner.nextLine();
                        adao.TransferFunds(acct_id1, acct_id2, amount);
                        break;
                    case "5":
                        System.out.println("========== " + fName + "'s Page: ==========");
                        MyArrayList<AccountItem> acctList;
                        acctList = adao.getAccountsByUser(fName);

                        for(int i =0; i < acctList.getElementsInArray(); i++) {
                            PrintMyList.printList(acctList.get(i));
                        }
                        System.out.println("============================================");
                        break;
                    case "6":
                        viewManager.navigate("Main Menu");
                        registered = false;
                        break;
                    default:
                        System.out.println("Please select a valid number (numeric values only)");
            }
        }
    }

    public void setfName(String fName) {
        RegisteredView.fName = fName;
    }

    public static void setAccount_id(int account_id) {
        RegisteredView.account_id = account_id;
    }

    public static void setCustomer_id(int customer_id) {
        RegisteredView.customer_id = customer_id;
    }
}
