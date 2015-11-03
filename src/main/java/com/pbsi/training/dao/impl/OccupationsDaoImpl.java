package com.pbsi.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.pbsi.training.beans.Occupations;
import com.pbsi.training.dao.OccupationsDao;

public class OccupationsDaoImpl implements OccupationsDao {

	private DataSource dataSource;
	
	/**
	 * Spring will automatically set this object because we have referenced this propery in applicationContext.xml
	 * @param dataSource
	 */


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Method to get all the occupations from the database
	 */
	public List<Occupations> findAll() {
		String sql = "SELECT * FROM Occupations";  // Raw Sql query to get all occupations from the database
		List<Occupations> occupationList=new ArrayList<Occupations>();
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection(); // This is where we will connect to the database
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(); // Query will be excuted in the DB engine here
			while (rs.next()) {
				Occupations occupation  = new Occupations();
				occupation.setId(rs.getInt("id"));
				occupation.setName(rs.getString("name") );
				occupationList.add(occupation);
			}
			rs.close();
			ps.close();
			return occupationList;
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
	 * Method to save occupatin values into the datbase
	 */

	public int save(Occupations occupation) {
		int returnValue = -1;
		String sql = "INSERT INTO occupations " + "(name) VALUES (?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, occupation.getName());
			returnValue = ps.executeUpdate();
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
		return returnValue;
	}


}
