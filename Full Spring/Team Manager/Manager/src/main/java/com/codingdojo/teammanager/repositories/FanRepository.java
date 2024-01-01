package com.codingdojo.teammanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.teammanager.models.Fan;
@Repository
public interface FanRepository extends CrudRepository<Fan, Long> {
	List<Fan> findAll();
}
