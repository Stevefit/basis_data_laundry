package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.Employee;
import com.example.basis_data_laundry.Item;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemRepository {
    private Connection conn;
    public ItemRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<Item> GetItems (Pagination pgn) throws SQLException {
        ArrayList<Item> items = new ArrayList<Item>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM items LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            items.add(
                    new Item(
                            rs.getString("item id"),
                            rs.getString("item name"),
                            rs.getInt("duration"),
                            rs.getDouble("price")
                    )
            );
        }
        return items;
    }
    public int GetItemCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(item_id) FROM items";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertItem(Item entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO items (item_id, item_name, duration, price) VALUES('%s','%s','%s','%d','%d')",
                entity.item_id,
                entity.item_name,
                entity.duration,
                entity.price
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
