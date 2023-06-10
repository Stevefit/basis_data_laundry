package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.Nota;
import com.example.basis_data_laundry.PaymentMethod;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaymentMethodRepository {
    private Connection conn;
    public PaymentMethodRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<PaymentMethod> GetPaymentMethods (Pagination pgn) throws SQLException {
        ArrayList<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM payment_method LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            paymentMethods.add(
                    new PaymentMethod(
                            rs.getString("payment method id"),
                            rs.getString("payment method name")
                    )
            );
        }
        return paymentMethods;
    }
    public int GetPaymentMethodCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(payment_method_id) FROM payment_method";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertPaymentMethod(PaymentMethod entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO payment_method (payment_method_id, payment_method_name) VALUES('%s','%s')",
                entity.payment_method_id,
                entity.payment_method_name
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
