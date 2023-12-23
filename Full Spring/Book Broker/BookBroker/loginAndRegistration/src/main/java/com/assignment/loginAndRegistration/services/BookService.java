package com.assignment.loginAndRegistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.assignment.loginAndRegistration.models.Book;
import com.assignment.loginAndRegistration.models.User;
import com.assignment.loginAndRegistration.repositories.BookRepository;



@Service
public class BookService {

	private final BookRepository bookRepository;
	 
	 public BookService(BookRepository bookRepository) {
	     this.bookRepository = bookRepository;
	 }
	 

	 public List<Book> allBooks() {
	     return bookRepository.findAll();
	 }
	 
	public List<Book> unborrowedBooks(User user){
		return bookRepository.findByBorrowerIdIsOrUserIdIs(null, user.getId());
	}
	
	public List<Book> borrowedBooks(User user){
		return bookRepository.findByBorrowerIdIs(user.getId());
	}
	
	public List<Book> myBooks(User user){
		return bookRepository.findByUserIdIs(user.getId());
	}
	 

	 public Book createBook(Book b, BindingResult result) {
		 
		 return bookRepository.save(b);

	 }
	 
		public Book updateBook(Book b) {
			return bookRepository.save(b);
		}
	 

	 public Book findBook(Long id) {
	     Optional<Book> optionalBook = bookRepository.findById(id);
	     if(optionalBook.isPresent()) {
	         return optionalBook.get();
	     } else {
	         return null;
	     }
	 }
	 
//	public Book updateBook(Long id, String title, String author, String thought) {
//	     Book book = findBook(id);
//	     if(book.getId()==id) {
//	    	 book.setTitle(title);
//	    	 book.setAuthor(author);
//	    	 book.setThought(thought);
//	    	 return createBook(book, null);
//	     }
//	     else {
//	    	 return null;
//	     }
//	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	
	public void removeBorrower(Book book) {
		book.setBorrower(null);
		bookRepository.save(book);
	}
	
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepository.save(book);
	}

}


