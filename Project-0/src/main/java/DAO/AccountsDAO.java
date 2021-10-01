package DAO;

import Utilities.ConnectionManager;
import Utilities.MyArrayList;
import views.RegisteredView;

import java.sql.*;

public class AccountsDAO implements AccountsCRUD {
    private Connection kahn;

    public AccountsDAO() {
        kahn = ConnectionManager.getConnection();
    }

    public AccountsDAO(Connection kahn) {
        this.kahn = kahn;
    }

    @Override
    public void newAcct(int account_id, double balance) {
        try {
            String sql = "INSERT INTO accounts VALUES(?, ?)";
            PreparedStatement pstmt = kahn.prepareStatement(sql);
            pstmt.setInt(1, account_id);
            pstmt.setDouble(2, balance);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
