package com.codingdojo.teammanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.teammanager.services.PlayerService;
import com.codingdojo.teammanager.services.TeamService;

@Controller
public class MainController {
@Autowired 
private TeamService teamServ;
@Autowired 
private PlayerService playerServ;
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("teams", teamServ.getAll());
		model.addAttribute("players",playerServ.getAll());
		return "index.jsp";
	}
}
