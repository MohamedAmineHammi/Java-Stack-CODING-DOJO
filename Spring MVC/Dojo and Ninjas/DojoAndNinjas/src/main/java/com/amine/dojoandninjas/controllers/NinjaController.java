package com.amine.dojoandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amine.dojoandninjas.models.Dojo;
import com.amine.dojoandninjas.models.Ninja;
import com.amine.dojoandninjas.services.DojoService;
import com.amine.dojoandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaServ;
	@Autowired
	private DojoService dojoServ;

//	Display Route - Display all ninjas | Create Ninja Form
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("ninja") Ninja ninja) {

		List<Ninja> all_ninjas = ninjaServ.allNinjas();
		model.addAttribute("ninjas", all_ninjas);

//		Ninja ninja = new Ninja();
//		model.addAttribute("ninja", ninja);

		// Get All Dojos
		List<Dojo> all_dojos = dojoServ.allDojos();
		model.addAttribute("all_dojos", all_dojos);
		return "create_ninja.jsp";

	}

	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Ninja> all_ninjas = ninjaServ.allNinjas();
			model.addAttribute("ninjas", all_ninjas);
			return "create_ninja.jsp";
		} else {
			Ninja newNinja = ninjaServ.createNinja(ninja);
			return "redirect:/";
		}

	}
}
