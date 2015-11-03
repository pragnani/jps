package com.pbsi.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbsi.training.entities.Occupations;

public interface OccupationRepository extends JpaRepository<Occupations, Integer>{

}
