package DAO;

import views.RegisteredView;

import java.sql.*;

public class LoginDAO implements LoginCRUD {
    private static Connection kahn;
    private int account_id;
    private static int customer_id;
    AccountsDAO adao = new AccountsDAO();
    private static RegisteredView reg = new RegisteredView();

    public LoginDAO(Connection kahn) {
        this.kahn = kahn;
    }

    private int getMostRecentCustomerId() throws SQLException{
        int newId = 0;
        String sql = "SELECT customer_id from customers";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        /*I will loop through the customer_ids gotten from the customer table until I have reached the end then return
        that number */
        while(rs.next()) {
            newId = rs.getInt("customer_id");
        }
        return newId;
    }
    public boolean RegisterAccount(String fName, String lName, String user, String pass, Double bal) {

        boolean valid = false;
        if(bal >= 0) {
            if (checkString(fName) && checkString(lName)) {
                try {
                    //getting the highest account_id and customer_id then adding one to each
                    account_id = adao.getMostRecentAcctId();
                    account_id++;
                    customer_id = getMostRecentCustomerId();
                    customer_id++;

                    String sql = "INSERT INTO accounts VALUES (?,?)";
                    PreparedStatement pstmt = kahn.prepareStatement(sql);
                    pstmt.setInt(1, account_id);
                    pstmt.setDouble(2, bal);

                    pstmt.executeUpdate();

                    sql = "INSERT INTO customers_to_accounts (customer_id, account_id) VALUES (?, ?)";
                    PreparedStatement pstmt2 = kahn.prepareStatement(sql);
                    pstmt2.setInt(1, customer_id);
                    pstmt2.setInt(2, account_id);

                    pstmt2.executeUpdate();

                    sql = "INSERT INTO customers VALUES (?, ?, ?)";
                    PreparedStatement pstmt3 = kahn.prepareStatement(sql);
                    pstmt3.setInt(1, customer_id);
                    pstmt3.setString(2, fName);
                    pstmt3.setString(3, lName);

                    pstmt3.executeUpdate();

                    sql = "INSERT INTO logins VALUES(?, ?, ?)";
                    PreparedStatement pstmt4 = kahn.prepareStatement(sql);
                    pstmt4.setInt(1, customer_id);
                    pstmt4.setString(2, user);
                    pstmt4.setString(3, pass);

                    pstmt4.executeUpdate();

                    //sending First Name, customer_id and account_id to RegisteredView for further use
                    reg.setfName(fName);
                    reg.setAccount_id(account_id);
                    reg.setCustomer_id(customer_id);
                    valid = true;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid character detected in First or Last Name\n");
                valid = false;
            }
            return valid;
        }
        else {
            System.out.println("Opening balance must be greater than or equal to 0");
            valid = false;
        }
        return valid;
    }

    public boolean checkLogin(String user, String pass) {

        String userName;
        String password;
        String fName;
        int account_id;
        try {
            String sql = "SELECT user_name, password, first_name, a.account_id, c.customer_id from logins l\n" +
                    "JOIN customers c ON l.customer_id = c.customer_id\n" +
                    "JOIN customers_to_accounts ca ON c.customer_id = ca.customer_id\n" +
                    "JOIN accounts a ON ca.account_id = a.account_id;";
            Statement stmt = kahn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            /*assigning values in the tables to variables then checking username and password brought it with each
            username and password in the table. If found boolean is set to true otherwise it returns false */
            while (rs.next()) {
                userName = rs.getString("user_name");
                password = rs.getString("password");
                fName = rs.getString("first_name");
                account_id = rs.getInt("account_id");
                customer_id = rs.getInt("customer_id");
                //sending First Name, customer_id and account_id to RegisteredView for further use
                reg.setfName(fName);
                reg.setAccount_id(account_id);
                reg.setCustomer_id(customer_id);

                if (userName.equals(user) && password.equals(pass)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkString(String str) {
        boolean valid = true;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <='Z')) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}