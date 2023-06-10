package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.DeliveryPriceRange;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeliveryPriceRangeRepository {
    private Connection conn;
    public DeliveryPriceRangeRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<DeliveryPriceRange> GetDeliveryPriceRanges (Pagination pgn) throws SQLException {
        ArrayList<DeliveryPriceRange> deliveryPriceRanges = new ArrayList<DeliveryPriceRange>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM delivery_price_range LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            deliveryPriceRanges.add(
                    new DeliveryPriceRange(
                            rs.getString("ddl id"),
                            rs.getString("start date"),
                            rs.getString("end date"),
                            rs.getInt("radius"),
                            rs.getDouble("minimum amount")
                    )
            );
        }
        return deliveryPriceRanges;
    }
    public int GetDelivery_Price_RangeCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(ddl_id) FROM delivery_price_range";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertDeliveryPriceRange(DeliveryPriceRange entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO delivery_price_range (ddl_id, start_date, end_date, radius, minimum_amount) VALUES('%s','%s','%s','%d','%d' )",
                entity.ddl_id,
                entity.start_date,
                entity.end_date,
                entity.radius,
                entity.minimum_amount
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
