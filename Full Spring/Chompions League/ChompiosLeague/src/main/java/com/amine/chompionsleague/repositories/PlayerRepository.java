package com.amine.chompionsleague.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amine.chompionsleague.models.Player;
import com.amine.chompionsleague.models.Team;

@Repository

public interface PlayerRepository extends CrudRepository<Player, Long> {
	List<Player> findAll();

	List<Player> findPlayersByTeam(Team team);

	List<Player> findAllByTeamId(Long teamId);
}
