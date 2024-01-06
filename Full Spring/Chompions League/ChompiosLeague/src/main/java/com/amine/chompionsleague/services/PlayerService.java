package com.amine.chompionsleague.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amine.chompionsleague.models.Player;
import com.amine.chompionsleague.models.Team;
import com.amine.chompionsleague.repositories.PlayerRepository;

@Service

public class PlayerService {

	// adding the Player repository as a dependency
	private final PlayerRepository playerRepository;

	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	// returns all the players
	public List<Player> allPlayers() {
		return playerRepository.findAll();
	}

	public List<Player> getPlayersByTeamId(Team team) {
		return playerRepository.findPlayersByTeam(team);
	}

	// creates a player
	public Player createPlayer(Player b) {
		return playerRepository.save(b);
	}

	// retrieves a player
	public Player findPlayer(Long id) {
		Optional<Player> optionalPlayer = playerRepository.findById(id);
		if (optionalPlayer.isPresent()) {
			return optionalPlayer.get();
		} else {
			return null;
		}
	}

	public Player updatePlayer(Player player) {

		return playerRepository.save(player);
	}

	// to delete a player, we simply pass in the player ID and if our repository
	// finds
	// it, the player will be deleted
	public void deletePlayer(Long id) {
		Optional<Player> optionalPlayer = playerRepository.findById(id);
		if (optionalPlayer.isPresent()) {
			playerRepository.deleteById(id);
		}
	}

	public void deletePlayersByTeamId(Long teamId) {
		// Find all players associated with the specified teamId
		List<Player> playersToDelete = playerRepository.findAllByTeamId(teamId);

		// Check if there are players to delete
		if (!playersToDelete.isEmpty()) {
			// Delete all the players
			playerRepository.deleteAll(playersToDelete);
		}
	}

}
