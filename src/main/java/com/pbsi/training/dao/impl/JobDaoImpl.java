package com.pbsi.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.pbsi.training.beans.Job;
import com.pbsi.training.dao.JobDao;

public class JobDaoImpl implements JobDao {

	private DataSource dataSource;
	
	/**
	 * Spring will automatically set this object because we have referenced this propery in applicationContext.xml
	 * @param dataSource
	 */

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Method to retrive all the jobs from the database and then convert them to the job java objects
	 */
	public List<Job> findAll() {
		String sql = "SELECT * FROM job";  // Sql query to get all the jobs
		List<Job> jobsList=new ArrayList<Job>();  // List used to save Collection of object, here the type 'Job'
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();  // this will create a connection with the database
			PreparedStatement ps = conn.prepareStatement(sql);  // Prepared statement used to query database in Jdbc, 
			// two other types of  "Statement" and "CallableStatements"
			
			ResultSet rs = ps.executeQuery();  // executeQuery will execute the query in database engine the give the result in Resultset Object
			while (rs.next()) {
				// We are creating a java object out of Query Results
				Job job = new Job();
				job.setId(rs.getInt("id"));
				
				job.setJobTitle(rs.getString("jobTitle") );
				job.setJobDescription(rs.getString("jobDescription") );
				job.setPostedBy(rs.getString("postedBy") );
				jobsList.add(job);
			}
			rs.close();
			ps.close();
			return jobsList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();  // We need to close the connection, otherwise it will cause deadlock
				} catch (SQLException e) {}
			}
		}
	}

	/**
	 * Method to save data to the database
	 */
	public void save(Job job) {
		String sql = "INSERT INTO job " + "(jobTitle,jobDescription, postedBy) VALUES (?,?,?)";  // query to insert data into database
		// ? are called query params, we will refer them with the index staring with 1...
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, job.getJobTitle());
			ps.setString(2, job.getJobDescription());
			ps.setString(3, job.getPostedBy());
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

}
