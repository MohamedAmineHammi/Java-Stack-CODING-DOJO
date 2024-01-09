package com.amine.househunter.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amine.househunter.models.Listing;
import com.amine.househunter.models.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
	List<Note> findAll();

	List<Note> findNotesByListing(Listing listing);

	List<Note> findAllByListingId(Long listingId);
}
