package DAO;

import Items.AccountItem;
import Utilities.MyArrayList;

public interface AccountsCRUD {

    //create
        //save object to database method
        public void newAcct(int custId, double balance);
    //read
        //reads the database and returns with all account balances under the registered account's name
        public MyArrayList<AccountItem> getAccountsByUser(String fName);
}
