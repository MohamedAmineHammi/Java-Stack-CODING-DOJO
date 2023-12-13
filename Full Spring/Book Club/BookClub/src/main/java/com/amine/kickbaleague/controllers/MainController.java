package com.amine.kickbaleague.controllers;

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

import com.amine.kickbaleague.models.Book;
import com.amine.kickbaleague.models.LoginUser;
import com.amine.kickbaleague.models.User;
import com.amine.kickbaleague.services.BookService;
import com.amine.kickbaleague.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class MainController {

	@Autowired
	private UserService userServ;

	@Autowired
	BookService bookService;

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
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}

	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		return "new_book.jsp";
	}

	@PostMapping("/new/book")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "new_book.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/home";
		}
	}

	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);

		Book book = bookService.findBook(id);
		if (book != null) {
			model.addAttribute("user", user);
			model.addAttribute("book", book);
			return "edit_book.jsp";
		}

		else
			return "redirect:/home";
	}

	@RequestMapping(value = "/books/edit/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "edit_book.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/home";
		}
	}

	@GetMapping("/books/{bookId}")
	public String oneBook(Model model, @PathVariable("bookId") Long bookId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "show_book.jsp";
	}

	@RequestMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Long bookId) {

		bookService.deleteBook(bookId);

		return "redirect:/home";

	}

}
