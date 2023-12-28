package com.codingdojo.fanpage.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.fanpage.models.Celebrity;

@Repository
public interface CelebrityRepository extends CrudRepository<Celebrity, Long> {
	List<Celebrity> findAll();

	List<Celebrity> findByNameContaining(String search);
}
