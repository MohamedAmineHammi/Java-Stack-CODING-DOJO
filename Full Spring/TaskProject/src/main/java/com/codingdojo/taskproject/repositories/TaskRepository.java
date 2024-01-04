package com.codingdojo.taskproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.taskproject.models.Task;
import com.codingdojo.taskproject.models.User;

@Repository

public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findAllByUser(User user);

	List<Task> findByUserAndPriority(User user, String priority);

	List<Task> findByUserAndTitleContaining(User user, String word);

	List<Task> findByStatus(String status);
}
