package DAO;

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

    @Override
    public void deleteByID(int id) throws SQLException {

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
