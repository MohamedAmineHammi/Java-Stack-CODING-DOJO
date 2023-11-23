package com.amine.disolaydate.controllers;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class Date {
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	    @RequestMapping("/date")
	    public String date() {



	        return "date.jsp";
	    }
	    @RequestMapping("/time")
	    public String time() {



	        return "time.jsp";
	    }
		
	}


