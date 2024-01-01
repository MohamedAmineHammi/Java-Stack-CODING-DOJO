package com.codingdojo.teammanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.teammanager.models.Coache;
@Repository
public interface CoacheRepository extends CrudRepository<Coache, Long> {
	List<Coache> findAll();
}
