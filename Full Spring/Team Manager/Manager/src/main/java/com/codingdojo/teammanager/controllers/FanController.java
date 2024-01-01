package com.codingdojo.teammanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.teammanager.models.Fan;
import com.codingdojo.teammanager.models.Team;
import com.codingdojo.teammanager.services.FanService;
import com.codingdojo.teammanager.services.TeamService;

import jakarta.validation.Valid;

@Controller
public class FanController {
	@Autowired
	private FanService fanServ;
	@Autowired
	private TeamService teamServ;

	@GetMapping("/fan")
	public String fan(@ModelAttribute("newFan") Fan newFan, Model model) {
		model.addAttribute("teams", teamServ.getAll());
		return "fan.jsp";
	}

	@PostMapping("/fanSave")
	public String saveFan(
	@Valid @ModelAttribute("newFan") Fan newFan, 
//	@RequestParam(value="fanName") String fanName, 
	@RequestParam(value="fanTeam") Team fanTeam,
	BindingResult result, 
	Model model) {		
		if (result.hasErrors()) {
			model.addAttribute("teams", teamServ.getAll());
			return "fan.jsp";
		} else {
			//System.out.println("FanController : team.id -->" + fanTeam.getId());
			fanServ.addTeamTofan(newFan, fanTeam);
			fanServ.create(newFan);

			return "redirect:/";
		}
	}
}
