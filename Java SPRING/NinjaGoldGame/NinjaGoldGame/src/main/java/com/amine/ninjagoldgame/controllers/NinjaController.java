package com.amine.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {
	@RequestMapping("/actions")
	public String actions() {
		return "actions.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public String index(
			HttpSession session,
			@RequestParam(value="farm", required=false) String farm,
			@RequestParam(value="cave", required=false) String cave,
			@RequestParam(value="house", required=false) String house,
			@RequestParam(value="quest", required=false) String quest
			) {
		int gold = 0;
		ArrayList<String> actions = new ArrayList<String>();
		
		SimpleDateFormat simpleFormat = new SimpleDateFormat("MMMM d Y h:mm a");
		
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", gold);
			session.setAttribute("actions", actions);
		}else {
			gold = (int) session.getAttribute("gold");
			actions = (ArrayList<String>) session.getAttribute("actions");
		}
		
		if(farm != null) {
			int amount = new Random().nextInt(11)+10;
			gold+=amount;
			actions.add(0, "You entered a farm and earned "+amount+" gold. ("+simpleFormat.format(new Date())+")");
			session.setAttribute("actions", actions);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		if(cave != null) {
			int amount = new Random().nextInt(6)+5;
			gold+=amount;
			actions.add(0, "You entered a cave and earned "+amount+" gold. ("+simpleFormat.format(new Date())+")");
			session.setAttribute("actions", actions);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		if(house != null) {
			int amount = new Random().nextInt(4)+2;
			gold+=amount;
			actions.add(0, "You entered a house and earned "+amount+" gold. ("+simpleFormat.format(new Date())+")");
			session.setAttribute("actions", actions);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		if(quest != null) {
			int amount = new Random().nextInt(101)-50;
			gold+=amount;
			if(amount>=0) {
				actions.add(0, "You completed a quest and earned "+amount+" gold. ("+simpleFormat.format(new Date())+")");
			}else {
				actions.add(0, "You failed a quest and lost "+(amount*-1)+" gold. ("+simpleFormat.format(new Date())+")");
			}
			session.setAttribute("actions", actions);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		return "index.jsp";
	}
}
