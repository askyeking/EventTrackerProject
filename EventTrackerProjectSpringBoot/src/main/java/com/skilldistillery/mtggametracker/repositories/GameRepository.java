package com.skilldistillery.mtggametracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mtggametracker.entities.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

		List<Game> findByDeck(String deck);
	
		List<Game> findByOpponentDeck(String deck);
		
		
	
}
