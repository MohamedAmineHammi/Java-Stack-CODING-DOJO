package com.codingdojo.teammanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.teammanager.models.Team;
import com.codingdojo.teammanager.services.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamServ;

	@GetMapping("/team")
	public String team(@ModelAttribute("newTeam") Team newTeam) {
		return "team.jsp";
	}

//	@PostMapping("/saveTeam")
//	public String saveTeam(@ModelAttribute("newTeam") Team newTeam, 
//	BindingResult result) {
//		if (result.hasErrors()) {
//		return "team.jsp";
//		} else {
//			teamServ.create(newTeam);
//			return "redirect:/";
//		}
//	}
	@PostMapping("/saveTeam")
	public String saveTeam(@ModelAttribute("newTeam") Team newTeam 
	) {
			teamServ.create(newTeam);
			return "redirect:/";
	}
}
