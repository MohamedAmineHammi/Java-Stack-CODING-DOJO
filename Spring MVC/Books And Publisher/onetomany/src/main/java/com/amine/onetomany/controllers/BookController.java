package com.amine.onetomany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.amine.onetomany.models.Book;
import com.amine.onetomany.models.Publisher;
import com.amine.onetomany.services.BookService;
import com.amine.onetomany.services.PublisherService;

import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookServ;
	@Autowired
	private PublisherService pubServ;

//	Display Route - Display all books | Create Book Form
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("book") Book book) {

		List<Book> all_books = bookServ.allBooks();
		model.addAttribute("books", all_books);

//		Book book = new Book();
//		model.addAttribute("book", book);

		// Get All Publishers
		List<Publisher> all_publishers = pubServ.allPublishers();
		model.addAttribute("all_publishers", all_publishers);
		return "index.jsp";

	}

//	Action Route - Create a Book
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Book> all_books = bookServ.allBooks();
			model.addAttribute("books", all_books);
			return "index.jsp";
		} else {
			Book newBook = bookServ.createBook(book);
			return "redirect:/";
		}

	}

//	Display Route - Display Edit Form
	@GetMapping("/edit/{id}")
	public String updateBook(Model model, @PathVariable("id") Long id) {

		Book thisBook = bookServ.findBook(id);
		model.addAttribute("book", thisBook);
		return "edit.jsp";

	}

// Action Route -- Edit a Book

	@PutMapping("/books/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			bookServ.updateBook(book);
			return "redirect:/";
		}
	}

// ACTION ROUTE -- DELET a BOOK

	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/";
	}

}