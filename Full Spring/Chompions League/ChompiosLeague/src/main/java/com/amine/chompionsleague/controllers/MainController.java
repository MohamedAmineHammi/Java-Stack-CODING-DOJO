 package com.amine.chompionsleague.controllers;

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

import com.amine.chompionsleague.models.LoginUser;
import com.amine.chompionsleague.models.Player;
import com.amine.chompionsleague.models.Team;
import com.amine.chompionsleague.models.User;
import com.amine.chompionsleague.services.PlayerService;
import com.amine.chompionsleague.services.TeamService;
import com.amine.chompionsleague.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class MainController {

	@Autowired
	private UserService userServ;

	@Autowired
	TeamService teamService;

	@Autowired
	PlayerService playerService;

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
		List<Team> teams = teamService.allTeams();
		model.addAttribute("teams", teams);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}

	@GetMapping("/teams/new")
	public String newTeam(@ModelAttribute("team") Team team, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		return "new_team.jsp";
	}

	@PostMapping("/new/team")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "new_team.jsp";
		} else {
			teamService.createTeam(team);
			return "redirect:/home";
		}
	}

	@PostMapping("/new/player")
	public String createPlayer(@Valid @ModelAttribute("player") Player player, BindingResult playerBindingResult,
			@RequestParam("teamId") Long teamId, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		if (playerBindingResult.hasErrors()) {
			User user = userServ.findById(userId);
			Team team = teamService.findTeam(teamId);
			model.addAttribute("team", team);
			model.addAttribute("user", user);
			List<Player> teamPlayers = playerService.getPlayersByTeamId(team);
			model.addAttribute("players", teamPlayers);

			return "show_team.jsp";
		} else {
			Team team = teamService.findTeam(teamId);

			Integer playerCount = team.getPlayersCount();
			team.setPlayersCount(playerCount += 1);
			player.setTeam(team);
			playerService.createPlayer(player);
			teamService.updateTeam(team);
			return "redirect:/teams/" + teamId;
		}
	}

	@RequestMapping("/teams/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);

		Team team = teamService.findTeam(id);
		if (team != null) {
			model.addAttribute("user", user);
			model.addAttribute("team", team);
			return "edit_team.jsp";
		}

		else
			return "redirect:/home";
	}

	@RequestMapping(value = "/teams/edit/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("team") Team team, BindingResult result) {
		if (result.hasErrors()) {
			return "edit_team.jsp";
		} else {
			teamService.updateTeam(team);
			return "redirect:/home";
		}
	}

	@GetMapping("/teams/{teamId}")
	public String oneTeam(Model model, @PathVariable("teamId") Long teamId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		Player player = new Player();
		model.addAttribute("player", player);

		Team team = teamService.findTeam(teamId);
		model.addAttribute("team", team);

		List<Player> teamPlayers = playerService.getPlayersByTeamId(team);
		model.addAttribute("players", teamPlayers);

		return "show_team.jsp";
	}

	@RequestMapping("/delete/{teamId}")
	public String deleteBook(@PathVariable("teamId") Long teamId) {

		playerService.deletePlayersByTeamId(teamId);
		teamService.deleteTeam(teamId);

		return "redirect:/home";

	}

}
