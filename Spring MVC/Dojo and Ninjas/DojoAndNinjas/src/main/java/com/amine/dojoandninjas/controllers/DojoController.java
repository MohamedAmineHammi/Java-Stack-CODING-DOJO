package com.amine.dojoandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amine.dojoandninjas.models.Dojo;
import com.amine.dojoandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoServ;

	@GetMapping("/dojos")
	public String dojos(@ModelAttribute("dojo") Dojo dojo) {
		return "create_dojo.jsp";
	}

	@PostMapping("/dojos")
	public String process_dojo_form(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {

		if (result.hasErrors()) {
			return "redirect:/dojos";
		} else {

			// save the dojo in DB
			Dojo newly_created_dojo = dojoServ.createDojo(dojo);
			return "redirect:/";
		}
	}

	@GetMapping("/dojos/{id}")
	public String one_dojo_ninjas(@PathVariable("id") Long id, Model model) {
		Dojo selected_dojo = dojoServ.findDojo(id);
		model.addAttribute("dojo", selected_dojo);
		return "one_dojo.jsp";
	}

}
