package com.assignment.loginAndRegistration.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.loginAndRegistration.models.Book;
import com.assignment.loginAndRegistration.services.BookService;
import com.assignment.loginAndRegistration.services.UserService;


@Controller
public class BookController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	 
	@GetMapping("/books")
	public String books(HttpSession session, Model model) {
		
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		Long userId1 = userService.findById(userId).getId();
		model.addAttribute("user", userService.findById(userId));
		model.addAttribute("userId", userId1);

		System.out.println(userId);

        
		List<Book> books = bookService.unborrowedBooks(userService.findById(userId));
		model.addAttribute("books", books);

		List<Book> myBooks = bookService.borrowedBooks(userService.findById(userId));
		model.addAttribute("myBooks", myBooks);
        
		
	    return "books.jsp";
	    
	}
	 
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model,
			HttpSession session
			) throws IOException {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userService.findById(userId));
	     
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
	     return "show.jsp";
	 }
	 
	@GetMapping("/addBook")
	public String addBook(
			HttpSession session, 
			Model model,
			@ModelAttribute("book") Book book
			) {
		Long userId = (Long) session.getAttribute("userId");
//		Long userId1 = userService.findById(userId).getId();
		model.addAttribute("user", userService.findById(userId));
//		model.addAttribute("userId", userId1);
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
	    return "add.jsp";
	}
	
	@PostMapping("/newBook")
	public String createBook(
		@Valid @ModelAttribute("book") Book book,
		BindingResult result,
		HttpSession session
		) throws SQLException {
		
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		
        if (result.hasErrors()) {
    	    return "add.jsp";
        } else {
        	bookService.createBook(book, result);
            return "redirect:/books";
        }
	    
	}
	

    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
    	
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
    }
    
	@PutMapping("/updateBook/{id}")
	public String update(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result, 
			HttpSession session) {	
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		 
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			bookService.updateBook(book);
			return "redirect:/show/{id}";
		}
	}
    
    @DeleteMapping("/deleteBook/{id}")
    public String destroyBook(@Valid @PathVariable("id") Long id,
    		HttpSession session
    		) {
    	
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
 	   bookService.deleteBook(id);
        return "redirect:/books";
    }

	
	@RequestMapping("/borrowBook/{bookID}")
	public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		bookService.addBorrower(bookService.findBook(bookID), userService.findById(userId));
		 
		return "redirect:/books";
	}
	
	@RequestMapping("/returnBook/{bookID}")
	public String returnBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		bookService.removeBorrower(bookService.findBook(bookID));
		 
		return "redirect:/books";
	}
	

    
}
