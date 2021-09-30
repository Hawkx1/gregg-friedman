package DAO;

import Utilities.ConnectionManager;
import Utilities.MyArrayList;
import models.LoginItem;
import java.sql.*;

public class LoginDAO implements ProjectCRUD<LoginItem> {
    private static Connection kahn;

    public LoginDAO(Connection kahn) { this.kahn = kahn; }

    @Override
    public void save(LoginItem row) throws SQLException {
        String sql = "SELECT * FROM logins WHERE customer_id = ?";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        pstmt.setInt(1, row.getCustomer_id());
    }

    @Override
    public LoginItem getItemByID(int id) throws SQLException {
        return null;
    }

    @Override
    public MyArrayList<LoginItem> getAllItems() throws SQLException {
        return null;
    }

    public void RegisterAccount(String user, String pass, String fName, String lName, Double bal){
        try {
            String sql = "INSERT INTO accounts VALUES (?,?)";
            PreparedStatement pstmt = kahn.prepareStatement(sql);
            pstmt.setInt(1, 1003);
            pstmt.setDouble(2, bal);

            pstmt.executeUpdate();

            sql = "INSERT INTO customers_to_accounts (customer_id, account_id) VALUES (?, ?)";
            pstmt.setInt(1, 3);
            pstmt.setInt(2, 1003);

            pstmt.executeUpdate();

            sql = "INSERT INTO customers VALUES (?, ?, ?)";
            pstmt.setInt(1, 3);
            pstmt.setString(2, fName);
            pstmt.setString(3, lName);

            pstmt.executeUpdate();

            sql = "INSERT INTO logins VALUES(?, ?, ?)";
            pstmt.setInt(1, 3);
            pstmt.setString(2, user);
            pstmt.setString(3, pass);

            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkLogin(String user, String pass) throws SQLException {

        String userName;
        String password;

        String sql = "SELECT * FROM logins";
        Statement stmt = kahn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            userName = rs.getString("user_name");
            password = rs.getString("password");

            if (userName.equals(user) && password.equals(pass)) {
                return true;
            }
        }
        return false;
    }
}
