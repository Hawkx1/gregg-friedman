package DAO;

import Utilities.MyArrayList;
import models.CustomersItem;

import java.sql.*;

public class CustomersDAO implements ProjectCRUD<CustomersItem> {
    private Connection kahn;

    public CustomersDAO(Connection kahn) { this.kahn = kahn; }

    @Override
    public void save(CustomersItem row) throws SQLException {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        PreparedStatement pstmt = kahn.prepareStatement(sql);
        pstmt.setInt(1, row.getCustomer_id());

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            //Item already exists
            String updateStatement = "UPDATE customers SET customer_id = ?," +
                    "first_name = ?, last_name = ?";
            pstmt = kahn.prepareStatement(updateStatement);
            pstmt.setInt(1, row.getCustomer_id());
            pstmt.setString(2, row.getFirst_name());
            pstmt.setString(3, row.getLast_name());

            pstmt.executeUpdate();
        }
    }

    @Override
    public CustomersItem getItemByID(int id) throws SQLException {
        return null;
    }

    @Override
    public MyArrayList<CustomersItem> getAllItems() throws SQLException {
        String sql = "SELECT * FROM accounts a JOIN customers_to_accounts cta ON a.account_id = cta(account_id)";
        Statement stmt = kahn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);
        return null;
    }

    @Override
    public void deleteByID(int id) throws SQLException {

    }
}
