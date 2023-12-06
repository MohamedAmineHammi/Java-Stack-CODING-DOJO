package com.amine.renderingallbooks.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amine.renderingallbooks.models.Book;
import com.amine.renderingallbooks.services.BookService;

@Controller
public class ViewsController {

	// Dependency Injection (creation d'instance du Service)
	private final BookService bookService;

	public ViewsController(BookService bookService) {
		this.bookService = bookService;
	}

	// READ ALL
	// (Get Request)
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books_list = bookService.allBooks();
		model.addAttribute("books", books_list);
		return "index.jsp";
	}

	// Display Route - Display Create Form :
	@RequestMapping("/new")
	public String display_create() {
		return "create.jsp";
	}

	// CREATE A BOOK (Post Request)
	@RequestMapping(value = "/createbook", method = RequestMethod.POST)
	public String create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "numberOfPages") Integer numOfPages) {

		Book newlyCreatedBook = new Book(title, desc, lang, numOfPages);
		Book savedBook = bookService.createBook(newlyCreatedBook);

		return "redirect:/books";
	}

	// FIND BY ID
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book foundBook = bookService.findBook(id);
		model.addAttribute("book", foundBook);
		return "showOne.jsp";
	}

}
