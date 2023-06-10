package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.TransactionDetail;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransactionDetailRepository {
    private Connection conn;
    public TransactionDetailRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<TransactionDetail> GetTransactionDetails (Pagination pgn) throws SQLException {
        ArrayList<TransactionDetail> transactionDetails = new ArrayList<TransactionDetail>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM transaction_detail LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            transactionDetails.add(
                    new TransactionDetail(
                            rs.getString("transaction detail id"),
                            rs.getString("laundry type"),
                            rs.getString("description"),
                            rs.getString("pick up date"),
                            rs.getDouble("item sub amount")
                    )
            );
        }
        return transactionDetails;
    }
    public int GetTransactionDetailCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(transaction_detail_id) FROM transaction_detail";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertTransactionDetail(TransactionDetail entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO transaction_detail (transaction_detail_id, laundry_type, description, pick_up_date, items_sub_amount) VALUES('%s','%s', '%s', '%s', '%d')",
                entity.transaction_detail_id,
                entity.laundry_type,
                entity.description,
                entity.pick_up_date,
                entity.items_sub_amount
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
