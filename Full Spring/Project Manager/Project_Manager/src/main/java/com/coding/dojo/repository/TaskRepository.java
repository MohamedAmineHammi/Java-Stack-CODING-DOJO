package com.coding.dojo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.dojo.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
	List<Task> findAll();
}
