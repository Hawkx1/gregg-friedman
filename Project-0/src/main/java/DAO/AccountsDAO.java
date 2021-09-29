package DAO;

import Utilities.MyArrayList;
import models.AccountsItem;
import java.sql.*;

public class AccountsDAO implements ProjectCRUD<AccountsItem> {
    private Connection kahn;

    public AccountsDAO(Connection kahn) { this.kahn = kahn; }

    @Override
    public void save(AccountsItem row) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        pstmt.setInt(1, row.getAccount_id());

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            //Item already exists
            String updateStatement = "UPDATE accounts SET account_id = ?, balance = ?";
            pstmt = kahn.prepareStatement(updateStatement);
            pstmt.setInt(1, row.getAccount_id());
            pstmt.setDouble(2, row.getBalance());

            pstmt.executeUpdate();
        }
        else {
            //Item doesn't exist
            String insertStatement = "INSERT INTO accounts (account_id, balance) VALUES (?, ?)";
            pstmt.setInt(1, row.getAccount_id());
            pstmt.setDouble(2, row.getBalance());

            pstmt.executeUpdate();
        }
    }

    @Override
    public AccountsItem getItemByID(int account_id) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        pstmt.setInt(1, account_id);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            return new AccountsItem(rs.getInt("account_id"), rs.getInt("balance"));
        }
        return null;
    }

    @Override
    public MyArrayList<AccountsItem> getAllItems() throws SQLException {
        String sql = "SELECT * FROM accounts";
        Statement stmt = kahn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        MyArrayList<AccountsItem> testList = new MyArrayList<>();

        while(rs.next()) {
            AccountsItem accItem = new AccountsItem(rs.getInt("account_id"), rs.getInt("balance"));
            testList.add(accItem);
        }
        return testList;
    }

    @Override
    public void deleteByID(int account_id) throws SQLException {
        String sql = "DELETE FROM accounts WHERE account_id = ?";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        pstmt.setInt(1, account_id);

        pstmt.executeUpdate();
    }
}
