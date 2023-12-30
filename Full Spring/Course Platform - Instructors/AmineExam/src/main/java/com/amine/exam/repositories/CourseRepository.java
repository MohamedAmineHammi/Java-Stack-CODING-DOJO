package com.amine.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amine.exam.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	List<Course> findAll();

}
