package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.Delivery;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeliveryRepository {
    private Connection conn;
    public DeliveryRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<Delivery> GetDeliveries (Pagination pgn) throws SQLException {
        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM deliveries LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            deliveries.add(
                    new Delivery(
                            rs.getString("delivery id"),
                            rs.getString("address"),
                            rs.getString("delivery type"),
                            rs.getDouble("delivery sub amount"),
                            rs.getInt("delivery radius")
                    )
            );
        }
        return deliveries;
    }
    public int GetDeliveryCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(delivery_id) FROM deliveries";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertDelivery(Delivery entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO deliveries (delivery_id, address, delivery_type, delivery_sub_amount, delivery_radius) VALUES('%s','%s','%s','%d','%d')",
                entity.delivery_id,
                entity.address,
                entity.delivery_type,
                entity.delivery_sub_amount,
                entity.delivery_radius
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
