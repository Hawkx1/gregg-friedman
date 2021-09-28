package DAO;

import Utilities.MyArrayList;

import java.sql.*;

public class CtADAO<CtAItem> implements ProjectCRUD<CtAItem>{
    private Connection kahn;

    @Override
    public void save(CtAItem row) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        //pstmt.setInt(1,);
    }

    @Override
    public CtAItem getItemByID(int junction_id) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        pstmt.setInt(1, accoun_id);

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
