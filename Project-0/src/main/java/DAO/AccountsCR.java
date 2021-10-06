package DAO;

import Items.AccountItem;
import Utilities.MyArrayList;

import java.sql.SQLException;

public interface AccountsCR {

    //create
        //save object to database method
        boolean newAcct(int custId, double balance);
    //read
        //reads the database and returns with all account balances under the registered account's name
        MyArrayList<AccountItem> getAccountsByUser(String fName);

    boolean DepositFunds(int account_id, double amount) throws SQLException;

    boolean WithdrawFunds(int account_id, double amount) throws SQLException;

    boolean CheckAccountExists(int account_id, int customer_id) throws SQLException;
}
