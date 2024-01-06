package com.amine.chompionsleague.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amine.chompionsleague.models.Team;
import com.amine.chompionsleague.repositories.TeamRepository;

@Service
public class TeamService {

	// adding the Team repository as a dependency
	private final TeamRepository teamRepository;

	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	// returns all the teams
	public List<Team> allTeams() {
		return teamRepository.findAll();
	}

	// creates a team
	public Team createTeam(Team b) {
		return teamRepository.save(b);
	}

	// retrieves a team
	public Team findTeam(Long id) {
		Optional<Team> optionalTeam = teamRepository.findById(id);
		if (optionalTeam.isPresent()) {
			return optionalTeam.get();
		} else {
			return null;
		}
	}

	public Team updateTeam(Team team) {

		return teamRepository.save(team);
	}

	// to delete a team, we simply pass in the team ID and if our repository finds
	// it, the team will be deleted
	public void deleteTeam(Long id) {
		Optional<Team> optionalTeam = teamRepository.findById(id);
		if (optionalTeam.isPresent()) {
			teamRepository.deleteById(id);
		}
	}

}
