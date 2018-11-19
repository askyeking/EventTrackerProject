package com.skilldistillery.mtggametracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mtggametracker.entities.Game;
import com.skilldistillery.mtggametracker.repositories.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepo;
	
	@Override
	public  List<Game> findAll(){
		return gameRepo.findAll();
	}
	
	
	@Override
	public Game findGameById(int id) {
		Game game = null;
		if(gameRepo.existsById(id)) {
			
		Optional<Game> gameOpt = gameRepo.findById(id);
			System.err.println(gameOpt);
			if(gameOpt.isPresent()) {
				game = gameOpt.get();
			 	
			}
			return game;
		}
		else {
			return null;
		}
	}
	
	
	@Override
	public List<Game> findGamesByDeck(String deck){
		return gameRepo.findByDeck(deck);
	}
	
	@Override
	public List<Game> findGameByOpponentDeck(String deck){
		return gameRepo.findByOpponentDeck(deck);
	}
	 
	@Override
	public Game submitGame(Game game) {
		game = gameRepo.saveAndFlush(game);
		return game;
	}
	
	@Override
	public Game update(Game changedGame, Integer id) {
		
		Optional<Game> optionalGame = gameRepo.findById(id);
		if(optionalGame.isPresent()) {
			changedGame.setId(id);
			gameRepo.saveAndFlush(changedGame);
		}
		return changedGame;
		
		
	}
	
	@Override
	public Boolean delete(int id) {
		Boolean isDeleted = false;
		if(gameRepo.existsById(id)) {
			gameRepo.deleteById(id);
			isDeleted = true;
			
		}
		
		return isDeleted;
	}
	
	
	
	
	
	
	
	
}
