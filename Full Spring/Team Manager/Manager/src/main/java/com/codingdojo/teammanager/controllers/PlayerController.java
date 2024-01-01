package com.codingdojo.teammanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.teammanager.models.Player;
import com.codingdojo.teammanager.services.PlayerService;
import com.codingdojo.teammanager.services.TeamService;

import jakarta.validation.Valid;

@Controller
public class PlayerController {
	@Autowired
	private PlayerService playerServ;

	@Autowired
	private TeamService teamServ;

	@GetMapping("/player")
	public String player(@ModelAttribute("newPlayer") Player newPlayer, Model model) {
		model.addAttribute("teams", teamServ.getAll());
		return "player.jsp";
	}

//	@PostMapping("/savePlayer")
//	public String savePlayer(
//	@Valid @ModelAttribute("newPlayer") Player newPlayer, 
//	BindingResult result,
//	Model model) {
//	if(result.hasErrors()) {
//		model.addAttribute("teams", teamServ.getAll());
//		return "player.jsp"; 
//	}else {
//		playerServ.create(newPlayer);
//		return "redirect:/";
//		
//	}
//	}
	@PostMapping("/savePlayer")
	public String savePlayer(@Valid @ModelAttribute("newPlayer") Player newPlayer, Model model) {
		playerServ.create(newPlayer);
		return "redirect:/";
	}

}
