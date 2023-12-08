package com.amine.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.dojoandninjas.models.Dojo;
import com.amine.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	// C R U D

	// adding the Dojo repository as a dependency
	@Autowired
	private DojoRepository dojoRepo;

	// ReadAll
	// returns all the Dojos
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}

	// CREATE
	// creates a Dojo
	public Dojo createDojo(Dojo d) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(p.getTitle.toLowerCase();)
		return dojoRepo.save(d);
	}

	// FIND by ID / Read One
	// retrieves a Dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> maybeDojo = dojoRepo.findById(id);
		if (maybeDojo.isPresent()) {
			return maybeDojo.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Dojo updateDojo(Dojo d) {
		return dojoRepo.save(d);
	}

	// DELETE
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
