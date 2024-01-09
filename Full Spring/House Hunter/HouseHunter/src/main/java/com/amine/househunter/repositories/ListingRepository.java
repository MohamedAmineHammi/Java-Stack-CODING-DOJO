package com.amine.househunter.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amine.househunter.models.Listing;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long> {
	List<Listing> findAll();

}
