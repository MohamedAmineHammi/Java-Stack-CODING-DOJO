package com.emine.drivinglicence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emine.drivinglicence.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	// get all persons
	List<Person> findAll();
}
