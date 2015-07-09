package com.mustafaiev.store;

import com.mustafaiev.models.Employee;
import com.mustafaiev.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by user on 08.07.2015.
 */
public class JdbcStorage {
    private final Connection connection;

    public JdbcStorage() {
        final Settings settings = Settings.getInstance();
        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


   // @Override
    public Collection<Employee> values() {
        final List<Employee> employees = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery("select * from companydata.department_staff")) {
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    //@Override
    public int add(Employee employee) {
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into companydata.department_staff (firstname,lastname,phone,email) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getEmail());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new user");
    }

   // @Override
    public void edit(Employee user) {

    }

   // @Override
    public void delete(int id) {

    }

   // @Override
    public Employee get(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from department_staff WHERE id = ?")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getString("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("User %s does not exists", id));
    }



   // @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
