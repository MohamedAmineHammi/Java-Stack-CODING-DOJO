package com.codingdojo.teammanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.teammanager.models.Player;
import com.codingdojo.teammanager.repositories.PlayerRepository;
@Service
public class PlayerService {
	@Autowired 
	private PlayerRepository playerRepo;

	// C R U D

	// getAll
	public List<Player> getAll(){
	return playerRepo.findAll();
	}
	// getById
	public Player getById(Long id) {
	Optional<Player> optional = playerRepo.findById(id);
	if(optional.isPresent()) { return optional.get();}else {return null;}
	}
	// create
	public Player create(Player Player) {
	return playerRepo.save(Player);}
	// update
	public Player update(Player Player) {
	return playerRepo.save(Player);}
	// delete
	public void delete(Long id) {
		Optional<Player> optional = playerRepo.findById(id);
		if(optional.isPresent()) { playerRepo.deleteById(id);}
	}
}
