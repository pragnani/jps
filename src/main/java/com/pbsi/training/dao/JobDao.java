package com.pbsi.training.dao;

import java.util.List;

import com.pbsi.training.beans.Job;

public interface JobDao {

	List<Job> findAll();

	void save(Job job1);

}
