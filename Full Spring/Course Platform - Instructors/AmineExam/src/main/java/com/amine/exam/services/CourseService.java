package com.amine.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amine.exam.models.Course;
import com.amine.exam.repositories.CourseRepository;

@Service
public class CourseService {

	// adding the Course repository as a dependency
	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	// returns all the Courses
	public List<Course> allCourses() {
		return courseRepository.findAll();
	}

	// creates a course
	public Course createCourse(Course b) {
		return courseRepository.save(b);
	}

	// retrieves a course
	public Course findCourse(Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);
		if (optionalCourse.isPresent()) {
			return optionalCourse.get();
		} else {
			return null;
		}
	}

	public Course updateCourse(Course course) {

		return courseRepository.save(course);
	}

	// Delete a Course
	public void deleteCourse(Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);
		if (optionalCourse.isPresent()) {
			courseRepository.deleteById(id);
		}
	}

}
