package com.amine.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.studentroster.models.Student;
import com.amine.studentroster.repositories.StudentRepository;

@Service
public class StudentService {

	// C R U D

	// adding the student repository as a dependency
	@Autowired
	private StudentRepository studentRepo;

	// ReadAll
	// returns all the students
	public List<Student> allStudents() {
		return studentRepo.findAll();
	}

	// CREATE
	// creates a Student
	public Student createStudent(Student s) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(s.getTitle.toLowerCase();)
		return studentRepo.save(s);
	}

	// FIND by ID / Read One
	// retrieves a Student
	public Student findStudent(Long id) {
		Optional<Student> maybeStudent = studentRepo.findById(id);
		if (maybeStudent.isPresent()) {
			return maybeStudent.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Student updateStudent(Student s) {
		return studentRepo.save(s);
	}

	// DELETE
	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
	}
}
