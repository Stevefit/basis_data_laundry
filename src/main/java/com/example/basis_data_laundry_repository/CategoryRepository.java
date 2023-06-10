package com.example.basis_data_laundry_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.basis_data_laundry.Category;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

public class CategoryRepository {
    private Connection conn;
    public CategoryRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<Category> GetCategories (Pagination pgn) throws SQLException {
        ArrayList<Category> category = new ArrayList<Category>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM categories LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            category.add(
                    new Category(
                            rs.getString("category id"),
                            rs.getString("category name")
                    )
            );
        }
        return category;
    }
    public int GetCategoryCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(category_id) FROM categories";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertCategory(Category entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO categories (category_id, category_name) VALUES('%s','%s')",
                entity.category_id,
                entity.category_name
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
