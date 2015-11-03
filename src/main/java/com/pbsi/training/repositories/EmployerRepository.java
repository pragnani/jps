package com.pbsi.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbsi.training.entities.Employer;

public interface EmployerRepository   extends JpaRepository<Employer, Integer>{

	Employer findByUserId(String username);

}
