package com.pbsi.training.dao;

import java.util.List;

import com.pbsi.training.beans.Occupations;

public interface OccupationsDao {

	public int save(Occupations occupation);
	public List<Occupations> findAll();
}
