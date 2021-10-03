package DAO;

import Items.AccountItem;
import Utilities.ConnectionManager;
import Utilities.MyArrayList;

import java.sql.*;

public class AccountsDAO implements AccountsCR {
    private Connection kahn;

    public AccountsDAO() {
        kahn = ConnectionManager.getConnection();
    }

    public AccountsDAO(Connection kahn) {
        this.kahn = kahn;
    }

    public int getMostRecentAcctId() throws SQLException {
        int newId = 0;
        String sql = "SELECT account_id from accounts";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        //I will loop through the account_ids gotten from the accounts table until I have reached the end of the Result
        // Set giving me the highest account_id then return that number
        while(rs.next()) {
            newId = rs.getInt("account_id");
        }
        return newId;
    }
    @Override
    public void newAcct(int custId, double balance) {
        try {
            //takes the highest account number then adds one to it
            int newAcctId = getMostRecentAcctId();
            newAcctId++;

            String sql = "INSERT INTO accounts VALUES(?, ?)";
            PreparedStatement pstmt = kahn.prepareStatement(sql);
            pstmt.setInt(1, newAcctId);
            pstmt.setDouble(2, balance);

            pstmt.executeUpdate();

            sql = "INSERT INTO customers_to_accounts (customer_id, account_id) VALUES(?, ?)";
            PreparedStatement pstmt2 = kahn.prepareStatement(sql);
            pstmt2.setInt(1, custId);
            pstmt2.setInt(2, newAcctId);

            pstmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean CheckAccountExists(int account_id, int customer_id) throws SQLException {
        String sql = "SELECT customer_id, account_id from customers_to_accounts " +
                "WHERE customer_id = ? AND account_id = ?";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        pstmt.setInt(1, customer_id);
        pstmt.setInt(2, account_id);
        ResultSet rs = pstmt.executeQuery();

        //Checks to see if an account exists if the query returns empty the ResultSet will be empty and therefore the
        // account does not exist
        if(!rs.next()) {
            System.out.println("Account does not exist or is not associated with your account. Please try again");
            return false;
        }
        else
            return true;
    }

    @Override
    public void DepositFunds(int account_id, double amount) throws SQLException{
        //Checks if the amount brought in is positive if it is funds will be deposited
        if(amount >= 0) {
            String sql = "UPDATE accounts " +
                  "SET balance = (balance + ?)" +
                  "WHERE account_id = ?";
            PreparedStatement pstmt2 = kahn.prepareStatement(sql);
            pstmt2.setDouble(1, amount);
            pstmt2.setInt(2, account_id);

            pstmt2.executeUpdate();

            System.out.println("Funds successfully deposited");
        } else
            System.out.println("Amount is less than or equal to 0 exiting program");
    }

    @Override
    public void WithdrawFunds(int account_id, double amount) throws SQLException{
        int balance;
        //Checks if the amount brought in is positive the function will continue and get the balance attached to the
        //account_id
        if(amount >= 0) {
            String sql = "SELECT balance from accounts WHERE account_id = ?";
            PreparedStatement pstmt = kahn.prepareStatement(sql);
            pstmt.setInt(1, account_id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            balance = rs.getInt("balance");
            //Checks if there is enough of a balance to withdraw the amount brought in
            if(balance >= amount) {
                sql = "UPDATE accounts " +
                        "SET balance = (balance - ?)" +
                        "WHERE account_id = ?";
                PreparedStatement pstmt2 = kahn.prepareStatement(sql);
                pstmt2.setDouble(1, amount);
                pstmt2.setInt(2, account_id);

                pstmt2.executeUpdate();

                System.out.println("Funds successfully withdrawn");
            }
            else
                System.out.println("Insufficient funds in account");
        } else
            System.out.println("Amount is less than or equal to 0 exiting program");
    }

    public MyArrayList<AccountItem> getAccountsByUser(String fName) {
        MyArrayList<AccountItem> acctList = new MyArrayList<>();
        try{
            String sql = "SELECT a.account_id, a.balance FROM accounts a " +
                    "JOIN customers_to_accounts cta ON a.account_id = cta.account_id " +
                    "JOIN customers c ON cta.customer_id = c.customer_id " +
                    "WHERE c.first_name = ?";
            PreparedStatement pstmt = kahn.prepareStatement(sql);
            pstmt.setString(1, fName);
            ResultSet rs = pstmt.executeQuery();

            //Takes the account_id and balances in the ResultSet and puts it into an AccountItem object then puts that
            //object into my ArrayList implementation
            while (rs.next()) {
                AccountItem newItem = new AccountItem(rs.getInt("account_id"), rs.getDouble("balance"));
                acctList.add(newItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acctList;
    }
}
