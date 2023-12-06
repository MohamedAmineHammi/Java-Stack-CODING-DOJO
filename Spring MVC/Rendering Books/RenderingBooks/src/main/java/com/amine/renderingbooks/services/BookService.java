package com.amine.renderingbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.renderingbooks.models.Book;
import com.amine.renderingbooks.repositories.BookRepository;

@Service
public class BookService {
	
	// C R U D

	// adding the book repository as a dependency
	@Autowired
	private BookRepository bookRepo;

	// ReadAll
	// returns all the books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}


	// FIND by ID / Read One
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> maybeBook = bookRepo.findById(id);
		if (maybeBook.isPresent()) {
			return maybeBook.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}

	// DELETE
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
