package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.Category;
import com.example.basis_data_laundry.Customer;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerRepository {
    private Connection conn;
    public CustomerRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<Customer> GetCustomers (Pagination pgn) throws SQLException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM customers LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            customers.add(
                    new Customer(
                            rs.getString("customer id"),
                            rs.getString("customer name"),
                            rs.getString("address"),
                            rs.getString("phone number")
                    )
            );
        }
        return customers;
    }
    public int GetCustomerCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(customer_id) FROM customers";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertCustomer(Customer entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO customers (customer_id, customer_name, address, phone_number) VALUES('%s','%s','%s','%s')",
                entity.customer_id,
                entity.customer_name,
                entity.address,
                entity.phone_number
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
