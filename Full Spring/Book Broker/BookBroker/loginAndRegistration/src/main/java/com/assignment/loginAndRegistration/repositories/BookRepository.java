package com.assignment.loginAndRegistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.loginAndRegistration.models.Book;



@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findAll();
	
	List<Book> findByUserIdIs(Long userId);
	
	List<Book> findByBorrowerIdIs(Long userId);
	
	List<Book> findByBorrowerIdIsOrUserIdIs(Long borrowerID, Long userId);
	
}
