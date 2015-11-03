package com.pbsi.training.dao;

import java.util.List;

import com.pbsi.training.beans.Employer;

public interface EmployerDao {

	/**
	 * All these methods will be implementd in "Impl" classes.
	 * @return
	 */
	List<Employer> findAll();

	void save(Employer employer);
	Employer findByUserId(String userid);
	
}
