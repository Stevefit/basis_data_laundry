package com.example.basis_data_laundry_repository;

import com.example.basis_data_laundry.Employee;
import com.example.basis_data_laundry_helper.Pagination;
import com.example.basis_data_laundry_helper.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeRepository {
    private Connection conn;
    public EmployeeRepository() throws SQLException {
        conn = connection.GetConnection();
    }
    public ArrayList<Employee> GetEmployees (Pagination pgn) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Statement stmt = conn.createStatement();
        String sql = String.format("SELECT * FROM employees LIMIT %o OFFSET %o", pgn.limit, pgn.offset);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            employees.add(
                    new Employee(
                            rs.getString("employee id"),
                            rs.getString("employee name"),
                            rs.getString("job title")
                    )
            );
        }
        return employees;
    }
    public int GetEmployeeCount() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT COUNT(employee_id) FROM employees";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            return rs.getInt(1);
        } else{
            return 0;
        }
    }
    public boolean InsertEmployee(Employee entity) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = String.format("INSERT INTO employees (employee_id, employee_name, job_title) VALUES('%s','%s','%s')",
                entity.employee_id,
                entity.employee_name,
                entity.job_title
        );
        System.out.println(sql);
        return (stmt.executeUpdate(sql) > 0);
    }
}
