package com.amine.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amine.studentroster.models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long> {
	// Read All
	List<Dorm> findAll();

}
