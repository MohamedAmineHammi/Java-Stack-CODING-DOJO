package com.codingdojo.teammanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.teammanager.models.Mascot;
@Repository
public interface MascotRepository extends CrudRepository<Mascot, Long> {
	List<Mascot> findAll();
}
