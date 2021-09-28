package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDAO {
    private static Connection kahn;

    public ProjectDAO(Connection kahn) { this.kahn = kahn; }

    public static void checkLogin() throws SQLException {

        String userName;
        String password;

        String sql = "SELECT * FROM logins";
        Statement stmt = kahn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        userName = rs.getString("username");
        password = rs.getString("password");

        System.out.println(userName);
        System.out.println(password);
    }
}
