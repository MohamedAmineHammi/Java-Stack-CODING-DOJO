package com.amine.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amine.savetravels.models.Travel;
import com.amine.savetravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	@Autowired
	private TravelService travelServ;

//	Display Route - Display all Travels | Create Travel Form
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("travel") Travel travel) {

		List<Travel> all_travels = travelServ.allTravels();
		model.addAttribute("travels", all_travels);
		return "index.jsp";

	}

//	Action Route - Create a Travel
	@PostMapping("/travels")
	public String createTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Travel> all_travels = travelServ.allTravels();
			model.addAttribute("travels", all_travels);
			return "index.jsp";
		} else {
			Travel newTravel = travelServ.createTravel(travel);
			return "redirect:/";
		}

	}

//	Display Route - Display Edit Form
	@GetMapping("/edit/{id}")
	public String updateTravel(Model model, @PathVariable("id") Long id) {

		Travel thisTravel = travelServ.findTravel(id);
		model.addAttribute("travel", thisTravel);
		return "edit.jsp";

	}
	// Action Route -- Edit a Travel

	@PutMapping("/travels/{id}")
	public String updateTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {

		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			travelServ.updateTravel(travel);
			return "redirect:/";
		}
	}
	// ACTION ROUTE -- DELETE a Travel

	@DeleteMapping("/travels/{id}")
	public String delete(@PathVariable("id") Long id) {
		travelServ.deleteTravel(id);
		return "redirect:/";
	}

	// FIND BY ID
	@RequestMapping("/travels/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Travel foundTravel = travelServ.findTravel(id);
		model.addAttribute("travel", foundTravel);
		return "showOne.jsp";
	}

}