package com.amine.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Daikichi {

	@RequestMapping("/daikichi")
	public String daikichi() {
		return "Welcome";
	}

	@RequestMapping("/daikichi/travel/{city}")
	public String update(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city;
	}

	@RequestMapping("/daikichi/lotto/{number}")
	public String message(@PathVariable("number") Integer num) {
		if (num % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers ";
		}
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	}
}
