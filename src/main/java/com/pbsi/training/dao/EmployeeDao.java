package com.pbsi.training.dao;

import java.util.List;

import com.pbsi.training.beans.Employee;

public interface EmployeeDao {

	/**
	 * These methods will be implmented by Impl classes
	 * @param employee
	 */
	void save(Employee employee);

	List<Employee> findAll();

	Employee findByUserId(String userid);

}
