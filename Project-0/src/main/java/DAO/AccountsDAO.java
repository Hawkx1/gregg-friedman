package DAO;

import Items.AccountItem;
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

    public int getMostRecentAcctId() throws SQLException {
        int newId = 0;
        String sql = "SELECT account_id from accounts";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            newId = rs.getInt("account_id");
        }
        return newId;
    }
    @Override
    public void newAcct(int custId, double balance) {
        try {
            int newAcctId = getMostRecentAcctId();
            newAcctId++;
            String sql = "INSERT INTO accounts VALUES(?, ?)";
            PreparedStatement pstmt = kahn.prepareStatement(sql);
            pstmt.setInt(1, newAcctId);
            pstmt.setDouble(2, balance);

            pstmt.executeUpdate();

            sql = "INSERT INTO customers_to_accounts (customer_id, account_id) VALUES(?, ?)";
            PreparedStatement pstmt2 = kahn.prepareStatement(sql);
            pstmt2.setInt(1, custId);
            pstmt2.setInt(2, newAcctId);

            pstmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MyArrayList<AccountItem> getAccountsByUser(String fName) {
        MyArrayList<AccountItem> acctList = new MyArrayList<>();
        try{
            String sql = "SELECT a.account_id, a.balance FROM accounts a " +
                    "JOIN customers_to_accounts cta ON a.account_id = cta.account_id " +
                    "JOIN customers c ON cta.customer_id = c.customer_id " +
                    "WHERE c.first_name = ?";
            PreparedStatement pstmt = kahn.prepareStatement(sql);
            pstmt.setString(1, fName);
            ResultSet rs = pstmt.executeQuery();



            while (rs.next()) {
                AccountItem newItem = new AccountItem(rs.getInt("account_id"), rs.getDouble("balance"));
                acctList.add(newItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acctList;
    }
}
