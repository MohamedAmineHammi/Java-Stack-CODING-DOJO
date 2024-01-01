package com.codingdojo.teammanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.teammanager.models.Team;
import com.codingdojo.teammanager.repositories.TeamRepository;

@Service
public class TeamService {
@Autowired 
private TeamRepository teamRepo;

// C R U D

// getAll
public List<Team> getAll(){
return teamRepo.findAll();
}
// getById
public Team getById(Long id) {
Optional<Team> optional = teamRepo.findById(id);
if(optional.isPresent()) { return optional.get();}else {return null;}
}
// create
public Team create(Team team) {
return teamRepo.save(team);}
// update
public Team update(Team team) {
return teamRepo.save(team);}
// delete
public void delete(Long id) {
	Optional<Team> optional = teamRepo.findById(id);
	if(optional.isPresent()) { teamRepo.deleteById(id);}
}

}
