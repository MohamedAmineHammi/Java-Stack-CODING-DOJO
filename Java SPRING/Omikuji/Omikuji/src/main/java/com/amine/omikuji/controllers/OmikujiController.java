package com.amine.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class OmikujiController {
	@RequestMapping("/omikuji")
	public String index() {

		return "index.jsp";
	}

	@RequestMapping(value = "/processOm", method = RequestMethod.POST)
	public String processOm(@RequestParam("number") int number, @RequestParam("cityName") String cityName,
			@RequestParam("personName") String personName, @RequestParam("hobby") String hobby,
			@RequestParam("livingThing") String livingThing, @RequestParam("someThing") String someThing,
			HttpSession session) {

		session.setAttribute("number", number);
		session.setAttribute("cityName", cityName);
		session.setAttribute("personName", personName);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("someThing", someThing);
		return "redirect:/show";
	}

	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
}
