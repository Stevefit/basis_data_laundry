package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.Nota;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NotaRepository {
    private Connection conn;
    public NotaRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<Nota> GetNotas (Pagination pgn) throws SQLException {
        ArrayList<Nota> notas = new ArrayList<Nota>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM nota LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            notas.add(
                    new Nota(
                            rs.getString("nota id"),
                            rs.getString("status")
                    )
            );
        }
        return notas;
    }
    public int GetNotaCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(nota_id) FROM nota";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertNota(Nota entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO nota (nota_id, status) VALUES('%s','%s')",
                entity.nota_id,
                entity.status
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
