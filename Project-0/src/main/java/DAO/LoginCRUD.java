package DAO;


import java.sql.SQLException;

public interface LoginCRUD {

    interface AccountsCRUD {

        //create
        //save object to database method
        void RegisterAccount(String fName, String lName, String user, String pass, Double bal);

        //read database object to verify identity
        boolean checkLogin(String user, String pass);

        int getMostRecentCustomerId() throws SQLException;
    }



}
