package com.amine.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.booksapi.models.Book;
import com.amine.booksapi.repositories.BookRepository;

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

	// CREATE
	// creates a book
	public Book createBook(Book b) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(b.getTitle.toLowerCase();)
		return bookRepo.save(b);
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
