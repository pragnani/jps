package com.pbsi.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbsi.training.entities.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	Employee findByUserId(String username);


}
