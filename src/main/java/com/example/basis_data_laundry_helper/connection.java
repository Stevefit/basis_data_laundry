package com.example.basis_data_laundry_helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private static Connection conn;
    private static Connection Connect() throws SQLException {
        //Dotenv dotenv = Dotenv.load();
        String host = "localhost";
        String port = "3306";
        String user = "root";
        String password = "";
        String dbName = "ukp";
        Connection con= DriverManager.getConnection(
                String.format("jdbc:mysql://%s:%s/%s", host, port, dbName),
                user,
                password
        );
        return con;
    }
    public static Connection GetConnection() throws SQLException {
        if(conn != null){
            return conn;
        } else{
            conn = Connect();
            return conn;
        }
    }
}
