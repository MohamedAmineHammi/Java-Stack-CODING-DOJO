package com.coding.dojo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.dojo.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	List<Project> findAll();
	@Query("SELECT p FROM Project p WHERE p.teamLeader.id <> :userId AND :userId NOT MEMBER OF p.teamMembers")
    List<Project> findProjectsNotRelatedToUser(Long userId);
}
