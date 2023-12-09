package com.amine.onetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.onetomany.models.Publisher;
import com.amine.onetomany.repositories.PublisherRepository;

@Service
public class PublisherService {

	// C R U D

	// adding the Publisher repository as a dependency
	@Autowired
	private PublisherRepository publisherRepo;

	// ReadAll
	// returns all the Publishers
	public List<Publisher> allPublishers() {
		return publisherRepo.findAll();
	}

	// CREATE
	// creates a Publisher
	public Publisher createPublisher(Publisher p) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(p.getTitle.toLowerCase();)
		return publisherRepo.save(p);
	}

	// FIND by ID / Read One
	// retrieves a Publisher
	public Publisher findPublisher(Long id) {
		Optional<Publisher> maybePublisher = publisherRepo.findById(id);
		if (maybePublisher.isPresent()) {
			return maybePublisher.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Publisher updatePublisher(Publisher p) {
		return publisherRepo.save(p);
	}

	// DELETE
	public void deletePublisher(Long id) {
		publisherRepo.deleteById(id);
	}
}
