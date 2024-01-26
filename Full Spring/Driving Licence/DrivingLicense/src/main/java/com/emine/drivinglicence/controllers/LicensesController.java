package com.emine.drivinglicence.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emine.drivinglicence.models.License;
import com.emine.drivinglicence.models.Person;
import com.emine.drivinglicence.services.LicenseService;
import com.emine.drivinglicence.services.PersonService;

@Controller
public class LicensesController {
	
	// inject LicenseService
	@Autowired
	LicenseService licenseService;
	
	// inject PersonService
	@Autowired
	PersonService personService;
	
	@GetMapping("/licenses/new")
	public String licenseForm(@ModelAttribute("license") License license,Model modelView) {
	////	******************** missed condition here :if the user have a license it doesn't allow to accessing to the form page to have another license********(one to one)
		//send all persons to the License form 
		modelView.addAttribute("allPersons",personService.getAllPersons());
		return "LicenseForm.jsp";
	}
	
	@PostMapping("/create/license")
	public String createLicense(@Valid @ModelAttribute("license") License license ,BindingResult result,Model modelView) {
		if(result.hasErrors()) {
			// send all persons to the form (don't lose all persons when the user render the page)
			modelView.addAttribute("allPersons",personService.getAllPersons());
			return"LicenseForm.jsp";
		}
	    licenseService.createLicense(license);
	    
	    return "redirect:/allPersons";
	}
	
	@GetMapping("/allPersons")
	public String showPersonsDetails(Model modelView) {
		List<Person> persons=personService.getAllPersons();
		modelView.addAttribute("persons",persons );
		System.out.println(persons);
		return "details.jsp";
	}

}
