package DAO;

//import Utilities.ConnectionManager;
import Utilities.MyArrayList;
import views.RegisteredView;

import java.sql.*;

public class LoginDAO implements LoginCRUD {
    private static Connection kahn;
    private static int account_id = 1001;
    private static int customer_id = 1;
    private static RegisteredView reg = new RegisteredView();
    //RegisteredView reg = new RegisteredView();

    public LoginDAO(Connection kahn) {
        this.kahn = kahn;
    }

    public void RegisterAccount(String fName, String lName, String user, String pass, Double bal) {
        try {
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

            reg.setfName(fName);
            reg.setAccount_id(account_id);
            account_id++;
            customer_id++;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkLogin(String user, String pass){

        String userName;
        String password;
        String fName;
        int account_id;

        try {
            String sql = "SELECT user_name, password, first_name, a.account_id from logins l\n" +
                    "JOIN customers c ON l.customer_id = c.customer_id\n" +
                    "JOIN customers_to_accounts ca ON c.customer_id = ca.customer_id\n" +
                    "JOIN accounts a ON ca.account_id = a.account_id;";
            Statement stmt = kahn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                userName = rs.getString("user_name");
                password = rs.getString("password");
                fName = rs.getString("first_name");
                account_id = rs.getInt("account_id");
                reg.setfName(fName);
                reg.setAccount_id(account_id);

                if (userName.equals(user) && password.equals(pass)) {
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
