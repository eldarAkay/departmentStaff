package com.mustafaiev.store;

import com.mustafaiev.models.Employee;
import com.mustafaiev.service.Settings;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by user on 08.07.2015.
 */
public class JdbcStorage extends ConnectionData implements Storage {

    private Connection getConnection() {
        try {
            loadConnectionData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(getDRIVER());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection c = null;
        try {
            c = DriverManager.getConnection(getURL(), getUSERNAME(), getPASSWORD());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }


   // @Override
    public Collection<Employee> values() {
        Connection connection = getConnection();
        final List<Employee> employees = new ArrayList<>();
        try (final Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery("select * from companydata.department_staff")) {
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("phone"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    //@Override
    public void add(Employee employee) {
        Connection connection = getConnection();
        try (final PreparedStatement statement = connection.prepareStatement("insert into companydata.department_staff (firstname,lastname,phone,email) VALUES (?,?,?,?)")) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getEmail());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   // @Override
    public void edit(Employee employee) {

        String insertTableSQL = "UPDATE companydata.department_staff SET firstname = ?,lastname = ?,phone = ?,email = ? WHERE id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setInt(5, employee.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   // @Override
    public void delete(int id) {
        String insertTableSQL = "DELETE  FROM companydata.department_staff  WHERE id = ?";
        Connection c = getConnection();
        try {
            PreparedStatement preparedStatement = c.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   // @Override
    public Employee get(int id) {
        Connection connection = getConnection();
        try (final PreparedStatement statement = connection.prepareStatement("select * from department_staff WHERE id = ?")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getString("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalStateException(String.format("User %s does not exists", id));
    }

}
