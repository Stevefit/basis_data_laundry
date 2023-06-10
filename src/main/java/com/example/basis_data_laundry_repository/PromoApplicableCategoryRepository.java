package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.PromoApplicableCategory;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PromoApplicableCategoryRepository {
    private Connection conn;
    public PromoApplicableCategoryRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<PromoApplicableCategory> GetPromoApplicableCategories(Pagination pgn) throws SQLException {
        ArrayList<PromoApplicableCategory> promoApplicableCategories = new ArrayList<PromoApplicableCategory>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM promo_applicable_category LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            promoApplicableCategories.add(
                    new PromoApplicableCategory(
                            rs.getString("pacs_id")
                    )
            );
        }
        return promoApplicableCategories;
    }
    public int GetPromoApplicableCategoryCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(pacs_id) FROM promo_applicable_category";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertPromoApplicableCategory(PromoApplicableCategory entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO promo (pacs_id) VALUES('%s')",
                entity.pacs_id
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
