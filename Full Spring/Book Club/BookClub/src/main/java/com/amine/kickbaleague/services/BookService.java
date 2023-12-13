package com.amine.kickbaleague.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amine.kickbaleague.models.Book;
import com.amine.kickbaleague.repositories.BookRepository;

@Service
public class BookService {

	// adding the Book repository as a dependency
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	public Book updateBook(Book book) {

		return bookRepository.save(book);
	}

	// to delete a book, we simply pass in the book ID and if our repository finds
	// it, the team will be deleted
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}

}
