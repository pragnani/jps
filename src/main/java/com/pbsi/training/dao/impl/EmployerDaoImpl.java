package com.pbsi.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.pbsi.training.beans.Employer;
import com.pbsi.training.dao.EmployerDao;

public class EmployerDaoImpl implements EmployerDao {

	private DataSource dataSource;

	/**
	 * Spring will automatically inject datasource object into our code, this is called dependency injection.
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * Method to get all the employers from the database
	 */

	public List<Employer> findAll() {
		String sql = "SELECT * FROM employer"; // Raw Database Query used to get all the employer
		List<Employer> employeeList=new ArrayList<Employer>();
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();  // This is where we will connect to the database
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();  // This statement will execute the query in db and return raw results as ResultSet Ojbect
			while (rs.next()) {
				Employer employer = new Employer();
				employer.setId(rs.getInt("id"));
				employer.setFirstName(rs.getString("firstName") );
				employer.setLastName(rs.getString("lastName") );
				employer.setUserId(rs.getString("userId") );
				employer.setPassword(rs.getString("password") );
				employeeList.add(employer);
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
 * Method to employer values into the database, connection and set up is same as above
 */
	public void save(Employer employer) {
		String sql = "INSERT INTO employer " + "(firstName,lastName,userId,email, password) VALUES (?,?,?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employer.getFirstName());
			ps.setString(2, employer.getLastName());
			ps.setString(3, employer.getUserId());
			ps.setString(4, employer.getEmail());
			ps.setString(5, employer.getPassword());
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

	@Override
	public Employer findByUserId(String userid) {
		String sql = "SELECT * FROM employer where userId= ?";
		Connection conn = null;
		Employer employer = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employer = new Employer();
				employer.setId(rs.getInt("id"));
				employer.setFirstName(rs.getString("firstName") );
				employer.setLastName(rs.getString("lastName") );
				employer.setUserId(rs.getString("userId") );
				employer.setPassword(rs.getString("password") );
			}
			rs.close();
			ps.close();
			return employer;
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
