package com.amine.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amine.lookify.models.Song;
import com.amine.lookify.repositories.SongRepository;

@Service
public class SongService {
	// C R U D

	// adding the travel repository as a dependency
	@Autowired
	private SongRepository songRepo;

	// ReadAll
	// returns all the Songs
	public List<Song> allSongs() {
		return songRepo.findAll();
	}

	// CREATE
	// creates a Song
	public Song createSong(Song b) {
		// on peut ajouter d'aute modification avant la creation ==
		// ex(b.getTitle.toLowerCase();)
		return songRepo.save(b);
	}

	// FIND by ID / Read One
	// retrieves a Song
	public Song findSong(Long id) {
		Optional<Song> maybeSong = songRepo.findById(id);
		if (maybeSong.isPresent()) {
			return maybeSong.get();
		} else {
			return null;
		}
	}
	
	//Find by Artist
    public List<Song> findSongsByArtist(String artist) {
        return songRepo.findByArtistContaining(artist);
    }

	

	// UPDATE
	public Song updateSong(Song b) {
		return songRepo.save(b);
	}

	// DELETE
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}


    public List<Song> findTop10ByOrderByRatingDesc() {
        return songRepo.findTop10ByOrderByRatingDesc();
    }
	}
