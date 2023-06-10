package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.Transaction;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransactionRepository {
    private Connection conn;
    public TransactionRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<Transaction> GetTransactions (Pagination pgn) throws SQLException {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM transaction LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            transactions.add(
                    new Transaction(
                            rs.getString("transaction id"),
                            rs.getString("entry date"),
                            rs.getString("finished date"),
                            rs.getDouble("down payment"),
                            rs.getDouble("total amount")
                    )
            );
        }
        return transactions;
    }
    public int GetTransactionCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(transaction_id) FROM transaction";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertTransaction(Transaction entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO transaction (transaction_id, entry_date, finished_date, down_payment, total_amount) VALUES('%s','%s', '%s', '%d', '%d')",
                entity.transaction_id,
                entity.entry_date,
                entity.finished_date,
                entity.down_payment,
                entity.total_amount
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
