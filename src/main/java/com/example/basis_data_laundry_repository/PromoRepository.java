package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.Promo;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PromoRepository {
    private Connection conn;
    public PromoRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<Promo> GetPromos (Pagination pgn) throws SQLException {
        ArrayList<Promo> promos = new ArrayList<Promo>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM promo LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            promos.add(
                    new Promo(
                            rs.getString("promo id"),
                            rs.getString("start_date"),
                            rs.getString("promo name"),
                            rs.getString("end_date"),
                            rs.getInt("amount")
                    )
            );
        }
        return promos;
    }
    public int GetPromoCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(promo_id) FROM promo";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertPromo(Promo entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO promo (promo_id, start_date, promo_name, end_date, amount) VALUES('%s','%s', '%s', '%s', '%d')",
                entity.promo_id,
                entity.start_date,
                entity.promo_name,
                entity.end_date,
                entity.amount
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
