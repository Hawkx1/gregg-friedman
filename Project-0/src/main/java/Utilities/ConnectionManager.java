package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionManager {
    private static Connection kahn;

    private ConnectionManager() {

    }

    public static Connection getConnection() throws SQLException, IOException {
        if(kahn == null) {
            Properties prop = new Properties();
            FileReader connectionProperties = new FileReader("src/main/resources/connection.properties");
            prop.load(connectionProperties);

            String connString = "jdbc:mariadb://" +
                    prop.getProperty("hostname") + ":" +
                    prop.getProperty("port") + "/" +
                    prop.getProperty("databaseName") + "?user=" +
                    prop.getProperty("user") + "&password=" +
                    prop.getProperty("password");

            kahn = DriverManager.getConnection(connString);
        }
        return kahn;
    }
}
