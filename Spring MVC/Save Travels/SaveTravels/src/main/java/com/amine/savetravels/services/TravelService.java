package com.amine.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.savetravels.models.Travel;
import com.amine.savetravels.repositories.TravelRepository;

@Service
public class TravelService {
	// C R U D

	// adding the travel repository as a dependency
	@Autowired
	private TravelRepository travelRepo;

	// ReadAll
	// returns all the travels
	public List<Travel> allTravels() {
		return travelRepo.findAll();
	}

	// CREATE
	// creates a travel
	public Travel createTravel(Travel b) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(b.getTitle.toLowerCase();)
		return travelRepo.save(b);
	}

	// FIND by ID / Read One
	// retrieves a travel
	public Travel findTravel(Long id) {
		Optional<Travel> maybeTravel = travelRepo.findById(id);
		if (maybeTravel.isPresent()) {
			return maybeTravel.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Travel updateTravel(Travel b) {
		return travelRepo.save(b);
	}

	// DELETE
	public void deleteTravel(Long id) {
		travelRepo.deleteById(id);
	}
}
