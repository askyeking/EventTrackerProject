package com.skilldistillery.mtggametracker.services;

import java.util.List;

import com.skilldistillery.mtggametracker.entities.Game;

public interface GameService {

	List<Game> findAll();

	Game findGameById(int id);

	List<Game> findGamesByDeck(String deck);

	List<Game> findGameByOpponentDeck(String deck);

	Game submitGame(Game game);

	Game update(Game changedGame, Integer id);

	Boolean delete(int id);
	
}
