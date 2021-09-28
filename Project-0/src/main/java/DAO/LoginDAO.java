package DAO;

import Utilities.MyArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class LoginDAO<LoginItem> implements ProjectCRUD<LoginItem> {
    private static Connection kahn;

    public LoginDAO(Connection kahn) { this.kahn = kahn; }

    @Override
    public void save(LoginItem row) throws SQLException {

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

    public static void checkLogin() throws SQLException {

        String userName;
        String password;

        String sql = "SELECT * FROM logins";
        Statement stmt = kahn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            userName = rs.getString("username");
            password = rs.getString("password");

            System.out.println(userName);
            System.out.println(password);
        }
    }
}
