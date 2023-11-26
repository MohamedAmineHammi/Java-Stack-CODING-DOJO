package com.amine.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	
	@RequestMapping("/your_server")
	public String yourServer(HttpSession session) {
		    // If the count is not already in session
		int count =0;
		    if (session.getAttribute("count") == null) {
		        // Use setAttribute to initialize the count in session
		        session.setAttribute("count", 0);
		    } else  {
		        // Increment the count by 1 using getAttribute and setAttribute
		         count = (int) session.getAttribute("count");
		        count++;
		        session.setAttribute("count", count);}
		    
			return "server.jsp";


		    }
	
	@RequestMapping("/your_server/counter")
	public String counter() {

		return "counter.jsp";
	}
	
	@RequestMapping("/your_server/counterBonus")
	public String counterBonus() {

		return "counterBonus.jsp";
	}
    @RequestMapping("/your_server/reset")
    public String reset(HttpSession session) {
        // Set the count back to zero
        session.setAttribute("count", 0);
        return "counter.jsp";
    }

}
