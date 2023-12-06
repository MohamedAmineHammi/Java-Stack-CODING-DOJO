package com.amine.burger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amine.burger.models.Burger;
import com.amine.burger.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	private BurgerService burgerServ;

//	Display Route - Display all burgers | Create Burger Form
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {

		List<Burger> all_burgers = burgerServ.allBurgers();
		model.addAttribute("burgers", all_burgers);
		return "index.jsp";
	}

//	Action Route - Create a Burger
	@PostMapping("/burgers")
	public String createBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Burger> all_burgers = burgerServ.allBurgers();
			model.addAttribute("burgers", all_burgers);
			return "index.jsp";
		} else {
			Burger newBurger = burgerServ.createBurger(burger);
			return "redirect:/";
		}

	}




}