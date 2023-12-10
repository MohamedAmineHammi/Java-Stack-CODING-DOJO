package com.amine.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amine.studentroster.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	// Read All
	List<Student> findAll();

}
