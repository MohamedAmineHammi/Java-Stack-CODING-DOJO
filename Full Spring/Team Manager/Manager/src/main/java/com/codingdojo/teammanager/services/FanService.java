package com.codingdojo.teammanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.teammanager.models.Fan;
import com.codingdojo.teammanager.models.Team;
import com.codingdojo.teammanager.repositories.FanRepository;

@Service
public class FanService {

	private boolean debug = true;

	@Autowired
	private FanRepository fanRepo;

	// C R U D

	// getAll
	public List<Fan> getAll() {
		return fanRepo.findAll();
	}

	// getById
	public Fan getById(Long id) {
		Optional<Fan> optional = fanRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	// create
	public Fan create(Fan Fan) {
		return fanRepo.save(Fan);
	}

	// update
	public Fan update(Fan Fan) {
		return fanRepo.save(Fan);
	}

	// delete
	public void delete(Long id) {
		Optional<Fan> optional = fanRepo.findById(id);
		if (optional.isPresent()) {
			fanRepo.deleteById(id);
		}
	}

	// relational
	// challenge to create a fan you should add a team to List<Team> teams !
	public void addTeamTofan(Fan fan, Team team) {
			fan.getTeams().add(team);		
	}
	// To avoid cascade, must set null.
	public void deleteTeamTofan(Fan fan, Team team) {
		for( int i = 0 ; i<fan.getTeams().size(); i++ )
		{
			if(fan.getTeams().get(i).getId() == team.getId()) {
				fan.getTeams().get(i).setId(null);
			}
		}
	}		
}
	

