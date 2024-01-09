package com.amine.househunter.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amine.househunter.models.Listing;
import com.amine.househunter.models.LoginUser;
import com.amine.househunter.models.Note;
import com.amine.househunter.models.User;
import com.amine.househunter.services.ListingService;
import com.amine.househunter.services.NoteService;
import com.amine.househunter.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class OussController {
	@Autowired
	private UserService userServ;

	@Autowired
	ListingService listingService;

	@Autowired
	NoteService noteService;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		userServ.register(newUser, result);

		if (result.hasErrors()) {

			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		session.setAttribute("userId", newUser.getId());

		return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}

		session.setAttribute("userId", user.getId());

		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);

		return "redirect:/";
	}

	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		List<Listing> listings = listingService.allListings();
		model.addAttribute("listings", listings);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}

	@GetMapping("/listings/new")
	public String newListing(@ModelAttribute("listing") Listing listing, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		return "new_listing.jsp";
	}

	@PostMapping("/new/listing")
	public String create(@Valid @ModelAttribute("listing") Listing listing, BindingResult result, HttpSession session,
			@RequestParam("due_date") String dueDateStr) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		// Manually parse the date input from the form into a Date object
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dueDate;
		try {
			dueDate = dateFormat.parse(dueDateStr);
		} catch (ParseException e) {
			result.rejectValue("due_date", "InvalidDateFormat", "Invalid date format");
			return "new_listing.jsp";
		}

		// Manually validate the due date
		Date currentDate = new Date();
		if (dueDate.after(currentDate)) {
			result.rejectValue("due_date", "PastDueDate", "Due date must be not in the future");
			return "new_listing.jsp";
		}

		if (result.hasErrors()) {
			return "new_listing.jsp";
		} else {
			listingService.createListing(listing);

			User user = userServ.findById(userId);
			user.getListings().add(listing);

			userServ.updateUser(user);

			return "redirect:/home";
		}
	}

	// Create Note
	@PostMapping("/new/note")
	public String createNote(@Valid @ModelAttribute("note") Note note, BindingResult noteBindingResult,
			@RequestParam("listingId") Long listingId, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		if (noteBindingResult.hasErrors()) {
			User user = userServ.findById(userId);
			Listing listing = listingService.findListing(listingId);
			model.addAttribute("listing", listing);
			model.addAttribute("user", user);
			List<Note> listingNotes = noteService.getNotesByListingId(listing);
			model.addAttribute("notes", listingNotes);

			return "show_listing.jsp";
		} else {
			Listing listing = listingService.findListing(listingId);

			Integer noteCount = listing.getNotesCount();
			listing.setNotesCount(noteCount += 1);
			note.setListing(listing);
			noteService.createNote(note);
			listingService.updateListing(listing);
			return "redirect:/listings/" + listingId;
		}
	}

	// Show Listing

	@GetMapping("/listings/{listingId}")
	public String oneListing(Model model, @PathVariable("listingId") Long listingId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		Note note = new Note();
		model.addAttribute("note", note);

		Listing listing = listingService.findListing(listingId);
		model.addAttribute("listing", listing);

		List<Note> listingNotes = noteService.getNotesByListingId(listing);
		model.addAttribute("notes", listingNotes);

		return "show_listing.jsp";
	}

	// Delete Listing
	@RequestMapping("/delete/{listingId}")
	public String deleteListing(@PathVariable("listingId") Long listingId) {

		noteService.deleteNotesByListingId(listingId);
		listingService.deleteListing(listingId);

		return "redirect:/home";

	}

	// Edit Listing

	@RequestMapping("/listings/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		Listing listing = listingService.findListing(id);
		if (listing != null) {

			model.addAttribute("listing", listing);
			return "edit_listing.jsp";
		}

		else
			return "redirect:/home";
	}

	@PostMapping(value = "/listings/{id}/edit")
	public String updateListing(@Valid @ModelAttribute("listing") Listing listing, @PathVariable("id") Long id,
			BindingResult result, @RequestParam("due_date") String dueDateStr, HttpSession session) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		// Manually parse the date input from the form into a Date object
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dueDate;
		try {
			dueDate = dateFormat.parse(dueDateStr);
		} catch (ParseException e) {
			result.rejectValue("due_date", "InvalidDateFormat", "Invalid date format");
			return "edit_listing.jsp";
		}

		// Manually validate the due date
		Date currentDate = new Date();
		if (dueDate.before(currentDate)) {
			result.rejectValue("due_date", "PastDueDate", "Due date must be in the future");
			return "edit_listing.jsp";
		}

		if (result.hasErrors()) {
			System.out.println("++++++++++++++++++++++++ there is error +++++++++++++++++++++");
			return "edit_listing.jsp";
		} else {

			User user = userServ.findById(userId);
			Listing thisListing = listingService.findListing(id);

			listing.setDue_date(dueDate);

			listingService.updateListing(listing);
			return "redirect:/home";
		}
	}
}
