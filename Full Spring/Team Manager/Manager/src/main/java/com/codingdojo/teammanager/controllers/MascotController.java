package com.codingdojo.teammanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.teammanager.models.Mascot;
import com.codingdojo.teammanager.services.MascotService;
import com.codingdojo.teammanager.services.TeamService;

import jakarta.validation.Valid;

@Controller
public class MascotController {
	@Autowired
	private MascotService mascotServ;
	@Autowired
	private TeamService teamServ;

	@GetMapping("/mascot")
	public String mascot(@ModelAttribute("newMascot") Mascot newMascot, Model model) {
		model.addAttribute("teams", teamServ.getAll());
		return "mascot.jsp";
	}
	@PostMapping("/mascotSave")
	public String saveMascot(@Valid @ModelAttribute("newMascot") Mascot newMascot,
	BindingResult result, Model model) {
	if(result.hasErrors()) {
		model.addAttribute("teams", teamServ.getAll());
		return "mascot.jsp";
	}else {
	mascotServ.create(newMascot);
	return "redirect:/";}
	}
}
