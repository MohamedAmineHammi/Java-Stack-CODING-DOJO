package com.amine.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amine.exam.models.Course;
import com.amine.exam.models.Student;
import com.amine.exam.repositories.StudentRepository;

@Service
public class StudentService {

	// adding the Student repository as a dependency
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	// returns all the Students
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}

	public List<Student> getStudentsByCourseId(Course course) {
		return studentRepository.findStudentsByCourse(course);
	}

	// creates a Student
	public Student createStudent(Student b) {
		return studentRepository.save(b);
	}

	// retrieves a Student
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}

	// Update Student
	public Student updateStudent(Student student) {

		return studentRepository.save(student);
	}

	// Delete Student
	public void deleteStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			studentRepository.deleteById(id);
		}
	}

	public void deleteStudentsByCourseId(Long courseId) {
		// Find all Students associated with the specified courseId
		List<Student> studentsToDelete = studentRepository.findAllByCourseId(courseId);

		// Check if there are students to delete
		if (!studentsToDelete.isEmpty()) {
			// Delete all the students
			studentRepository.deleteAll(studentsToDelete);
		}
	}

}
