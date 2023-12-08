package com.amine.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.dojoandninjas.models.Ninja;
import com.amine.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	// C R U D

	// adding the Ninja repository as a dependency
	@Autowired
	private NinjaRepository ninjaRepo;

	// ReadAll
	// returns all the Ninjas
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}

	// CREATE
	// creates a Ninja
	public Ninja createNinja(Ninja n) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(b.getTitle.toLowerCase();)
		return ninjaRepo.save(n);
	}

	// FIND by ID / Read One
	// retrieves a Ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> maybeNinja = ninjaRepo.findById(id);
		if (maybeNinja.isPresent()) {
			return maybeNinja.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Ninja updateNinja(Ninja n) {
		return ninjaRepo.save(n);
	}

	// DELETE
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
