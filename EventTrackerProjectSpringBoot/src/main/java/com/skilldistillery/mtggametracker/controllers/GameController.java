package com.skilldistillery.mtggametracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mtggametracker.entities.Game;
import com.skilldistillery.mtggametracker.services.GameService;

@RestController
@RequestMapping("api")
public class GameController {
	
	@Autowired
	private GameService gSvc;
	
	
	@GetMapping("games")
	public List<Game> allGames(){
		return gSvc.findAll();
	}
	
	@GetMapping("games/{id}")
	public Game gameById(@PathVariable("id") int id) {
		return gSvc.findGameById(id);
	}
	
	@GetMapping("gamesDeck/{deck}")
	public List<Game> gameByDeck(@PathVariable("deck") String deck) {
		return gSvc.findGamesByDeck(deck);
	}
	@GetMapping("gamesOpponentDeck/{deck}")
	public List<Game> gameByOpponentDeck(@PathVariable("deck") String deck) {
		return gSvc.findGameByOpponentDeck(deck);
	}
	
	
	
	
	
	
	@PostMapping("games")
	public String create(@RequestBody Game game, HttpServletRequest req, HttpServletResponse resp) {
		game = gSvc.submitGame(game);
		resp.setStatus(201);
		String newResourceUrl = req.getRequestURL() +"/" + game.getId();
		resp.setHeader("Location", newResourceUrl);
		String responseBody="{ \"result\": \"created\", \"id\":" + game.getId() + ",\"url:\":\"" + newResourceUrl + "\"}";
		return responseBody;
	}
	
	
	@PutMapping("games/{id}")
	public Game updateGame(@PathVariable("id") int id, @RequestBody Game game) {
		return gSvc.update(game, id);
	}

	
	@DeleteMapping("games/{id}")
	public Boolean deleteGame(@PathVariable("id") int id) {
		return gSvc.delete(id);
	}
}
