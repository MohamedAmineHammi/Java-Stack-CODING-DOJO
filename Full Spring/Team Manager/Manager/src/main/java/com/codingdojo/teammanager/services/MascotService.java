package com.codingdojo.teammanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.teammanager.models.Mascot;
import com.codingdojo.teammanager.repositories.MascotRepository;

@Service
public class MascotService {
	@Autowired 
	private MascotRepository mascotRepo;

	// C R U D

	// getAll
	public List<Mascot> getAll(){
	return mascotRepo.findAll();
	}
	// getById
	public Mascot getById(Long id) {
	Optional<Mascot> optional = mascotRepo.findById(id);
	if(optional.isPresent()) { return optional.get();}else {return null;}
	}
	// create
	public Mascot create(Mascot Mascot) {
	return mascotRepo.save(Mascot);}
	// update
	public Mascot update(Mascot Mascot) {
	return mascotRepo.save(Mascot);}
	// delete
	public void delete(Long id) {
		Optional<Mascot> optional = mascotRepo.findById(id);
		if(optional.isPresent()) { mascotRepo.deleteById(id);}
	}
}
