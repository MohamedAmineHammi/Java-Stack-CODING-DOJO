package com.emine.drivinglicence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emine.drivinglicence.models.Person;
import com.emine.drivinglicence.repositories.PersonRepository;

@Service
public class PersonService {
	
	// inject Person repository using annotation
	@Autowired
	private PersonRepository personRepo;
	
	
	// get all persons
	public List<Person> getAllPersons(){
		return personRepo.findAll();
	}
	
	// get one person
	public Person getOnePerson(Long id) {
		 Optional<Person> optionalPerson=personRepo.findById(id);
		 if(optionalPerson.isPresent()) {
			 // if the person with particular id exist
			 return optionalPerson.get();
		 }
		 // else(Person doesn't exist)
		 return null;
	}
	
	// create one person
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}

}
