package com.amine.lookify.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amine.lookify.models.Song;
import com.amine.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongController {
	@Autowired
	private SongService songServ;

	// Home Page
	@RequestMapping("/")
	public String index() {

		return "index.jsp";
	}

//	Display Route - Display all Songs 
	@GetMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("song") Song song) {

		List<Song> all_songs = songServ.allSongs();
		model.addAttribute("songs", all_songs);
		return "dashboard.jsp";

	}

    // Action Route - Create a Song (GET)
    @GetMapping("/songs/new")
    public String displayCreateSongForm(@ModelAttribute("song") Song song) {
        return "create.jsp";
    }
//	Action Route - Create a Song
	@PostMapping("/songs/new")
	@GetMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Song> all_songs = songServ.allSongs();
			model.addAttribute("songs", all_songs);
			return "create.jsp";
		} else {
			Song newSong = songServ.createSong(song);
			return "redirect:/songs/new";
		}

	}
	
	// ACTION ROUTE -- DELETE a Travel

	@DeleteMapping("/songs/{id}")
	public String delete(@PathVariable("id") Long id) {
		songServ.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	// FIND BY ID
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song foundSong = songServ.findSong(id);
		model.addAttribute("song", foundSong);
		return "showOne.jsp";
	}
//Find by Artist 
	@GetMapping("/songs/search")
	public String searchSongsByArtist(@RequestParam("artist") String artist, Model model) {
	    List<Song> searchResults = songServ.findSongsByArtist(artist);
	    model.addAttribute("songs", searchResults);
	    model.addAttribute("artist", artist);
	    return "searchResults.jsp";
	}
	
	// Find Top 10 Songs
	@GetMapping("/songs/top-ten")
	public String topTenSongs(Model model) {
	    List<Song> topTenSongs = songServ.findTop10ByOrderByRatingDesc();
	    model.addAttribute("songs", topTenSongs);
	    return "topTenSongs.jsp";
	}

}
