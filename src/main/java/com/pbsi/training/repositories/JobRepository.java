package com.pbsi.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbsi.training.entities.Job;

public interface JobRepository  extends JpaRepository<Job, Integer>{ 

}
