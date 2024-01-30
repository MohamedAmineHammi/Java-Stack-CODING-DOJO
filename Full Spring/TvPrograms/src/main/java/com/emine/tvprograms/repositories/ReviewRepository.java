package com.emine.tvprograms.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emine.tvprograms.models.Review;
import com.emine.tvprograms.models.Show;
import com.emine.tvprograms.models.User;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	List<Review> findAll();
	List<Review> findByShowIs(Show show);
    List<Review> findByUser(User user);
}
