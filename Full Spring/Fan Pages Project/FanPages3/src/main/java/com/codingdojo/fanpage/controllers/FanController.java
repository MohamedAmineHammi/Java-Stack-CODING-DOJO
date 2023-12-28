package com.codingdojo.fanpage.controllers;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.fanpage.models.Celebrity;
import com.codingdojo.fanpage.models.LoginUser;
import com.codingdojo.fanpage.models.User;
import com.codingdojo.fanpage.services.CelebrityService;
import com.codingdojo.fanpage.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class FanController {

	@Autowired
	private UserService userServ;

	@Autowired
	private CelebrityService celebrityService;

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
	public String home(@ModelAttribute("celebrity") Celebrity celebrity, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		} else {

			List<Celebrity> allCelebrities = celebrityService.allCelebrities();
			model.addAttribute("allCelebrities", allCelebrities);

			// grab the loggedIn user and send it to jsp
			User thisLoggedInUser = userServ.findById(userId);
			model.addAttribute("thisUser", thisLoggedInUser);
			return "dashboard.jsp";
		}
	}

	// Add Celebrity

	@GetMapping("/celebrities/new")
	public String newCelebrity(@ModelAttribute("celebrity") Celebrity celebrity, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		return "new_celebrity.jsp";
	}

	@PostMapping("/new/celebrity")
	public String createCelebrity(@Valid @ModelAttribute("celebrity") Celebrity celebrity, BindingResult result,
			Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "new_celebrity.jsp";
		} else {
			// grap the id curent user login
			// grap the curent user login
			User curentUser = userServ.findById(userId);
			celebrityService.createCelebrity(celebrity);
			return "redirect:/home";
		}
	}

	// Show one Celebrity

	@GetMapping("/celebrities/{celebrityId}")
	public String oneCelebrity(Model model, @PathVariable("celebrityId") Long celebrityID, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		Celebrity celebrity = celebrityService.findCelebrity(celebrityID);
		model.addAttribute("celebrity", celebrity);

		// followers
		// find the user from the db using id
		User thisLoggedInUser = userServ.findById(userId);
		// grab the list of celebrities from user obj
		List<Celebrity> favsCelebrities = thisLoggedInUser.getFollowCelebs();
		model.addAttribute("favCelebrities", favsCelebrities);
		// followers

		List<User> followers = celebrity.getFollowers();
		model.addAttribute("followers", followers);
		// hhh

		return "show_celebrity.jsp";
	}

	// Edit Celebrity

	@RequestMapping("/celebrities/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);

		Celebrity celebrity = celebrityService.findCelebrity(id);
		if (celebrity != null) {
			model.addAttribute("user", user);
			model.addAttribute("celebrity", celebrity);
			return "edit_celebrity.jsp";
		}

		else
			return "redirect:/home";
	}

	@RequestMapping(value = "/celebrities/edit/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("celebrity") Celebrity celebrity, BindingResult result, HttpSession s) {
		if (result.hasErrors()) {
			return "edit_celebrity.jsp";
		} else {

			Celebrity originalCelebrity = celebrityService.findCelebrity(celebrity.getId());
			// grab the id curent user login
			Long userId = (Long) s.getAttribute("userId");
			// grab the curent user login
			User curentUser = userServ.findById(userId);

			celebrityService.updateCelebrity(celebrity);
			return "redirect:/home";
		}
	}

	@RequestMapping("/delete/{celebrityId}")
	public String deleteCelebrity(@PathVariable("celebrityId") Long celebrityId) {

		celebrityService.deleteCelebrity(celebrityId);

		return "redirect:/home";

	}

	// Search Celebrity By Name
	@GetMapping("/celebrities/search")
	public String searchCelebritiesByName(@RequestParam("name") String name, Model model) {
		List<Celebrity> searchResults = celebrityService.findCelebritiesByName(name);
		model.addAttribute("celebrities", searchResults);
		model.addAttribute("name", name);
		return "searchResults.jsp";
	}

	// Follow !!

	// Add the current user to followers list celebrity of this celebrity

	@GetMapping("/addtofav/{celebrityId}")
	public String addTofav(@PathVariable("celebrityId") Long celebrityID, HttpSession session) {
		// grab the user id from the session
		Long userId = (Long) session.getAttribute("userId");
		// find the user from the db using id
		User thisLoggedInUser = userServ.findById(userId);
		// find the celebrity using the celebrityID
		Celebrity thisCelebrity = celebrityService.findCelebrity(celebrityID);
		// M:N connection
		thisCelebrity.getFollowers().add(thisLoggedInUser);
		// Save to db
		celebrityService.updateCelebrity(thisCelebrity);

		return "redirect:/home";

	}

	// Remove the current user from the followers list
	@GetMapping("/removefromfav/{celebrityId}")
	public String removeFromFav(@PathVariable("celebrityId") Long celebrityID, HttpSession session) {
		// grab the user id from the session
		Long userId = (Long) session.getAttribute("userId");
		// find the user from the db using id
		User thisLoggedInUser = userServ.findById(userId);
		// find the celebrity using the celebrityID
		Celebrity thisCelebrity = celebrityService.findCelebrity(celebrityID);
		// M:N connection
		thisCelebrity.getFollowers().remove(thisLoggedInUser);
		// Save to db
		celebrityService.updateCelebrity(thisCelebrity);
		return "redirect:/home";
	}

	// grab the current user's list of favs celebritys

//	@GetMapping("/favorites")
//	public String getFavs(Model model, HttpSession s) {
//
//		// grab the current loggedin user
//		Long userId = (Long) s.getAttribute("userId");
//		// find the user from the db using id
//		User thisLoggedInUser = userServ.findById(userId);
//		// grab the list of celebrities from user obj
//		List<Celebrity> favsCelebrities = thisLoggedInUser.getFollowCelebs();
//		model.addAttribute("favCelebrities", favsCelebrities);
//		return "favorites.jsp";
//	}

//	@GetMapping("/celebrities/{celebrityId}/followers")
//	public String showFollowers(@PathVariable("celebrityId") Long celebrityID, Model model, HttpSession session) {
//	    Long userId = (Long) session.getAttribute("userId");
//	    if (userId == null) {
//	        return "redirect:/";
//	    }
//
//	    User user = userServ.findById(userId);
//	    model.addAttribute("user", user);
//
//	    Celebrity celebrity = celebrityService.findCelebrity(celebrityID);
//	    model.addAttribute("celebrity", celebrity);
//
//	    List<User> followers = celebrity.getFollowers();
//	    model.addAttribute("followers", followers);
//
//	    return "show_followers.jsp";
//	}

}
