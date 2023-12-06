package com.amine.renderingbooks.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amine.renderingbooks.models.Book;
import com.amine.renderingbooks.services.BookService;

@Controller
public class BookController {

	// Dependency Injection (creation d'instance du Service)
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}


	// FIND BY ID
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book foundBook = bookService.findBook(id);
		model.addAttribute("book", foundBook);
		return "showOne.jsp";
	}

}
