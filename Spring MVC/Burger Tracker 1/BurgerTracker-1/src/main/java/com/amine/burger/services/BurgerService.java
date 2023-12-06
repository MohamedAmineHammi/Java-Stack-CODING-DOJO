package com.amine.burger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.burger.models.Burger;
import com.amine.burger.repositories.BurgerRepository;

@Service
public class BurgerService {
	// C R U D

	// adding the book repository as a dependency
	@Autowired
	private BurgerRepository burgerRepo;

	// ReadAll
	// returns all the books
	public List<Burger> allBurgers() {
		return burgerRepo.findAll();
	}

	// CREATE
	// creates a book
	public Burger createBurger(Burger b) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(b.getTitle.toLowerCase();)
		return burgerRepo.save(b);
	}

	// FIND by ID / Read One
	// retrieves a book
	public Burger findBurger(Long id) {
		Optional<Burger> maybeBurger = burgerRepo.findById(id);
		if (maybeBurger.isPresent()) {
			return maybeBurger.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Burger updateBurger(Burger b) {
		return burgerRepo.save(b);
	}

	// DELETE
	public void deleteBurger(Long id) {
		burgerRepo.deleteById(id);
	}
}
