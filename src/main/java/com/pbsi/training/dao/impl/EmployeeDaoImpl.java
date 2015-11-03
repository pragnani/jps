package com.pbsi.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.pbsi.training.beans.Employee;
import com.pbsi.training.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {

	private DataSource dataSource;

	/**
	 * Spring will automatically place datasource object into our code, as we have mention it in aplicationContext.xml
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Method to get all the employees from the databae
	 */
	public List<Employee> findAll() {
		String sql = "SELECT * FROM employee"; // Raw Query to get all the employees from database
		List<Employee> employeeList=new ArrayList<Employee>();
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();  // this is where we will connect to the database
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery(); // Query will be executed in Db engine when we call executeQuery()
			while(rs.next()) {
				Employee employee  = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setFirstName(rs.getString("firstName") );
				employee.setLastName(rs.getString("lastName") );
				employee.setUserId(rs.getString("userId") );
				employee.setPassword(rs.getString("password") );
				employee.setCurrentOccupation(rs.getString("currentOccupation") );
				employeeList.add(employee);
			}
			rs.close();
			ps.close();
			return employeeList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	/**
	 * Method to save employee Details on to the database
	 */

	public void save(Employee employee) {
		String sql = "INSERT INTO employee " + "(firstName,lastName,userId,email, password,currentOccupation) VALUES (?,?,?,?,?,?)"; // raw query to insert data into database.
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getUserId());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPassword());
			ps.setString(6, employee.getCurrentOccupation());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * Method to get Employee by Userid
	 */
	@Override
	public Employee findByUserId(String userid) {
		String sql = "SELECT * FROM employee where userId= ?";
		Connection conn = null;
		Employee employee = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setFirstName(rs.getString("firstName") );
				employee.setLastName(rs.getString("lastName") );
				employee.setUserId(rs.getString("userId") );
				employee.setPassword(rs.getString("password") );
				employee.setCurrentOccupation(rs.getString("currentOccupation") );
			}
			rs.close();
			ps.close();
			return employee;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}


}
