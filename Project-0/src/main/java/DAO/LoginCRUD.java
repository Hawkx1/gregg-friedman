package DAO;


public interface LoginCRUD {

    public interface AccountsCRUD {

        //create
        //save object to database method
        public void RegisterAccount(String fName, String lName, String user, String pass, Double bal);

        //read database object to verify identity
        public boolean checkLogin(String user, String pass);
    }



}
