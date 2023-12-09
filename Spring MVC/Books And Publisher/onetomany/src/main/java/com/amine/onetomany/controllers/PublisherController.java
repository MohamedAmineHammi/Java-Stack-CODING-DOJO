package com.amine.onetomany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amine.onetomany.models.Publisher;
import com.amine.onetomany.services.PublisherService;

import jakarta.validation.Valid;

@Controller
public class PublisherController {
	@Autowired
	private PublisherService pubServ;

	@GetMapping("/publishers")
	public String publishers(@ModelAttribute("publisher") Publisher publisher) {
		return "create_publisher.jsp";
	}

	@PostMapping("/publishers")
	public String process_publisher_form(@Valid @ModelAttribute("publisher") Publisher publisher,
			BindingResult result) {

		if (result.hasErrors()) {
			return "redirect:/publishers";
		} else {

			// save the publisher in DB
			Publisher newly_created_publisher = pubServ.createPublisher(publisher);
			return "redirect:/";
		}
	}

	@GetMapping("/publishers/{id}")
	public String one_publisher_books(@PathVariable("id") Long id, Model model) {
		Publisher selected_publisher = pubServ.findPublisher(id);
		model.addAttribute("publisher", selected_publisher);
		return "one_publisher.jsp";
	}

}
