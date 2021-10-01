package DAO;

import Utilities.MyArrayList;

import java.sql.SQLException;
import java.util.List;

public interface AccountsCRUD {

    //create
        //save object to database method
        public void newAcct(int account_id, double balance);
}
