package com.codingdojo.teammanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.teammanager.models.Coache;
import com.codingdojo.teammanager.repositories.CoacheRepository;

@Service
public class CoacheService {

	@Autowired 
	private CoacheRepository coacheRepo;

	// C R U D

	// getAll
	public List<Coache> getAll(){
	return coacheRepo.findAll();
	}
	// getById
	public Coache getById(Long id) {
	Optional<Coache> optional = coacheRepo.findById(id);
	if(optional.isPresent()) { return optional.get();}else {return null;}
	}
	// create
	public Coache create(Coache Coache) {
	return coacheRepo.save(Coache);}
	// update
	public Coache update(Coache Coache) {
	return coacheRepo.save(Coache);}
	// delete
	public void delete(Long id) {
		Optional<Coache> optional = coacheRepo.findById(id);
		if(optional.isPresent()) { coacheRepo.deleteById(id);}
	}



}
