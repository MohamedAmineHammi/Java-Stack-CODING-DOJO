package com.amine.househunter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amine.househunter.models.Listing;
import com.amine.househunter.models.Note;
import com.amine.househunter.repositories.NoteRepository;

@Service
public class NoteService {

	// adding the Note repository as a dependency
	private final NoteRepository noteRepository;

	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	// returns all the Notes
	public List<Note> allNotes() {
		return noteRepository.findAll();
	}

	public List<Note> getNotesByListingId(Listing listing) {
		return noteRepository.findNotesByListing(listing);
	}

	// creates a Note
	public Note createNote(Note b) {
		return noteRepository.save(b);
	}

	// retrieves a Note
	public Note findNote(Long id) {
		Optional<Note> optionalNote = noteRepository.findById(id);
		if (optionalNote.isPresent()) {
			return optionalNote.get();
		} else {
			return null;
		}
	}

	// Update Note
	public Note updateNote(Note note) {

		return noteRepository.save(note);
	}

	// Delete Note
	public void deleteNote(Long id) {
		Optional<Note> optionalNote = noteRepository.findById(id);
		if (optionalNote.isPresent()) {
			noteRepository.deleteById(id);
		}
	}

	public void deleteNotesByListingId(Long listingId) {
		// Find all Notes associated with the specified listingId
		List<Note> notesToDelete = noteRepository.findAllByListingId(listingId);

		// Check if there are notes to delete
		if (!notesToDelete.isEmpty()) {
			// Delete all the notes
			noteRepository.deleteAll(notesToDelete);
		}
	}

}
