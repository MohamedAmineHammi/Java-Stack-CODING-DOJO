package com.amine.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amine.exam.models.Course;
import com.amine.exam.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findAll();

	List<Student> findStudentsByCourse(Course course);

	List<Student> findAllByCourseId(Long courseId);
}
