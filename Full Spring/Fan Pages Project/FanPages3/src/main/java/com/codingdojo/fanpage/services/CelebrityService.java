package com.codingdojo.fanpage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.fanpage.models.Celebrity;
import com.codingdojo.fanpage.repositories.CelebrityRepository;

@Service
public class CelebrityService {

	@Autowired
	private CelebrityRepository celebrityRepository;

	// returns all the celebrities
	public List<Celebrity> allCelebrities() {
		return celebrityRepository.findAll();
	}

	// creates a celebrity
	public Celebrity createCelebrity(Celebrity c) {
		return celebrityRepository.save(c);

	}

	// retrieves a celebrity
	public Celebrity findCelebrity(Long id) {
		Optional<Celebrity> optionalCelebrity = celebrityRepository.findById(id);
		if (optionalCelebrity.isPresent()) {
			return optionalCelebrity.get();
		} else {
			return null;
		}
	}
	//Find by Name
    public List<Celebrity> findCelebritiesByName(String name) {
        return celebrityRepository.findByNameContaining(name);
    }

	// Update Celebrity
	public Celebrity updateCelebrity(Celebrity celebrity) {

		return celebrityRepository.save(celebrity);
	}

	// Delete Celebrity
	public void deleteCelebrity(Long id) {
		Optional<Celebrity> optionalCelebrity = celebrityRepository.findById(id);
		if (optionalCelebrity.isPresent()) {
			celebrityRepository.deleteById(id);
		}
		

	}
}
