package com.amine.renderingbooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amine.renderingbooks.models.Book;
import com.amine.renderingbooks.services.BookService;



@RestController
public class BookCtrl {
	// Dependency Injection (creation d'instance du Service)
	private final BookService bookService;

	public BookCtrl(BookService bookService) {
		this.bookService = bookService;
	}

	// READ ALL
	// (Get Request)
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}



	// FIND BY ID
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book foundBook = bookService.findBook(id);
		return foundBook;
	}

    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		// we create a new Book object with the values we passed in
		Book book = new Book(title, desc, lang, numOfPages);
		// we then set the ID of the new Book object to equal the ID of the Book we are updating
		book.setId(id);
		// now we can use our bookService to update the book
		Book updatedBook = bookService.updateBook(book);
        return updatedBook;
    }
    
	// to delete a row, we must use the 'DELETE' method
	// in Postman, you will also have to use the 'DELETE' method
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    // we only need the Book ID to delete the book in our bookService
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
