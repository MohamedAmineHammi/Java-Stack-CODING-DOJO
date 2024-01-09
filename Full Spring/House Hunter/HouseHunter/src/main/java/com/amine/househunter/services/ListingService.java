package com.amine.househunter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amine.househunter.models.Listing;
import com.amine.househunter.repositories.ListingRepository;

@Service
public class ListingService {
	// adding the Listing repository as a dependency
	private final ListingRepository listingRepository;

	public ListingService(ListingRepository listingRepository) {
		this.listingRepository = listingRepository;
	}

	// returns all the Listings
	public List<Listing> allListings() {
		return listingRepository.findAll();
	}

	// creates a listing
	public Listing createListing(Listing b) {
		return listingRepository.save(b);
	}

	// retrieves a listing
	public Listing findListing(Long id) {
		Optional<Listing> optionalListing = listingRepository.findById(id);
		if (optionalListing.isPresent()) {
			return optionalListing.get();
		} else {
			return null;
		}
	}

	public Listing updateListing(Listing listing) {

		return listingRepository.save(listing);
	}

	// Delete a Listing
	public void deleteListing(Long id) {
		Optional<Listing> optionalListing = listingRepository.findById(id);
		if (optionalListing.isPresent()) {
			listingRepository.deleteById(id);
		}
	}

}
