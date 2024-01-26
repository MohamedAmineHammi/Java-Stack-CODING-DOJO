package com.emine.drivinglicence.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emine.drivinglicence.models.Person;
import com.emine.drivinglicence.services.PersonService;

@Controller
public class PersonCntroller {
	
	// inject the PersonService
	@Autowired
	PersonService personService;

	// route to home page
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	//person form route
	@GetMapping("/person/new")
	public String personForm(@ModelAttribute("person") Person person) {
		return "PersonForm.jsp";
	}
	
	// create person
	@PostMapping("/create/person")
	public String createPerson(@Valid @ModelAttribute("person") Person person ,BindingResult result) {
		if(result.hasErrors()) {
			return "PersonForm.jsp";
		}
		// else (all fields is full with all validations in the model)
		personService.createPerson(person);
		return "redirect:/";
	}
	
	@GetMapping("/person/{id}")
	public String personInfo(@PathVariable("id") Long id,Model modelView) {
		Person person= personService.getOnePerson(id);
		modelView.addAttribute("person", person);
		return "PersonInfo.jsp";
		
	}
	
}
