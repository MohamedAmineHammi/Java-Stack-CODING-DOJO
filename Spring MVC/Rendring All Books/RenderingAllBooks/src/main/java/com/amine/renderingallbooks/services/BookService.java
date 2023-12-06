package com.amine.renderingallbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amine.renderingallbooks.models.Book;
import com.amine.renderingallbooks.repositories.BookRepository;

@Service
public class BookService {

	// C R U D

	// adding the book repository as a dependency
	// Dependencie Injection (DI) (to create an instance from BookRepository)
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// ReadAll
	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// CREATE
	// creates a book
	public Book createBook(Book b) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(b.getTitle.toLowerCase();)
		return bookRepository.save(b);
	}

	// FIND by ID
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
}
