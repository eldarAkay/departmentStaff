package com.mustafaiev.store;

import com.mustafaiev.models.Employee;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by user on 09.07.2015.
 */
public class DBC extends ConnectionData {
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
    public ArrayList<Employee> getEmpList() {
        ArrayList<Employee> dataList = new ArrayList<Employee>();
        String insertTableSQL = "select * from department_staff";
        Connection c = getConnection();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(insertTableSQL);
            while (rs.next()) {
                Employee tempEmployee = new Employee(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("phone"),rs.getString("email"));
                dataList.add(tempEmployee);
            }
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
        return dataList;
    }

   // @Override
    public void deleteEmp(Integer id) {
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

  //  @Override
    public void addEmp(Employee employee) {
        String insertTableSQL = "INSERT INTO companydata.department_staff (firstname,lastname,phone,email) VALUES (?,?,?,?)";
        Connection c = getConnection();
        try {
            PreparedStatement preparedStatement = c.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getEmail());
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

  //  @Override
    public void updateEmp(Employee employee) {
        String insertTableSQL = "UPDATE companydata.department_staff SET firstname = ?,lastname = ?,phone = ?,email = ? WHERE id = ?";
        Connection c = getConnection();
        try {
            PreparedStatement preparedStatement = c.prepareStatement(insertTableSQL);
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
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   // @Override
   /* public Employee getEmp(Integer id) {
        String insertTableSQL = "select * from department_staff WHERE id = ?";
        Connection c = getConnection();
        Employee employee;
        try {
            PreparedStatement preparedStatement = c.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                employee = new Employee(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("phone"),rs.getString("email"));
            }

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
        return employee;
    }*/
}
