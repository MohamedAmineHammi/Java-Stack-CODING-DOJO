package com.amine.onetomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amine.onetomany.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
	// Read All
	List<Publisher> findAll();

}
