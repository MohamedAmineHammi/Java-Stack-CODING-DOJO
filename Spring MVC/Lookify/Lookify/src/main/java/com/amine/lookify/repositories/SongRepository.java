package com.amine.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amine.lookify.models.Song;
@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();

	// this method finds songs with Artist name containing the search string
	List<Song> findByArtistContaining(String search);

	List<Song> findTop10ByOrderByRatingDesc();
}
