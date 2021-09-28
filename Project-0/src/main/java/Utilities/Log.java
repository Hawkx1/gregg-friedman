package Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Log {

    private String userName;
    private static Connection kahn;

    public Log(String userName) {
        this.userName = userName;
    }

    public void checkLoginQuery() throws SQLException {
    }

    public String LogOut() {
        this.userName = "";
        return userName;
    }
}
