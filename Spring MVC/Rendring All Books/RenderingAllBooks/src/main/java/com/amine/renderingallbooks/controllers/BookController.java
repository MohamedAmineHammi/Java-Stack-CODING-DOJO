package com.amine.renderingallbooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amine.renderingallbooks.models.Book;
import com.amine.renderingallbooks.services.BookService;

@RestController
public class BookController {

	// Dependency Injection (creation d'instance du Service)
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// READ ALL
	// (Get Request)
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}

	// CREATE A BOOK (Post Request)
	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "numberOfPages") Integer numOfPages) {
		Book newCreatedBook = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(newCreatedBook);
	}

	// FIND BY ID
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book foundBook = bookService.findBook(id);
		return foundBook;
	}
}
