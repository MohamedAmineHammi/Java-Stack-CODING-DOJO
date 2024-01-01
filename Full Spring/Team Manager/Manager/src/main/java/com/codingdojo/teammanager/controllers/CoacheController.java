package com.codingdojo.teammanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoacheController {
	@GetMapping("/coache")
	public String coache() {
	return "coache.jsp"; }
}
