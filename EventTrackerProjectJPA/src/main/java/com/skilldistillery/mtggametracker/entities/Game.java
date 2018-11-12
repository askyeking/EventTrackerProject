package com.skilldistillery.mtggametracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="opponent_name")
	private String opponentName;
	
	@Column(name="game_wins")
	private Integer gameWins;
	
	@Column(name="game_losses")
	private Integer gameLosses;
	
	@Column(name="game_draws")
	private Integer gameDraws;
	
	private String deck;
	
	@Column(name="opponent_deck")
	private String opponentDeck;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpponentName() {
		return opponentName;
	}

	public void setOpponentName(String opponentName) {
		this.opponentName = opponentName;
	}

	public Integer getGameWins() {
		return gameWins;
	}

	public void setGameWins(Integer gameWins) {
		this.gameWins = gameWins;
	}

	public Integer getGameLosses() {
		return gameLosses;
	}

	public void setGameLosses(Integer gameLosses) {
		this.gameLosses = gameLosses;
	}

	public Integer getGameDraws() {
		return gameDraws;
	}

	public void setGameDraws(Integer gameDraws) {
		this.gameDraws = gameDraws;
	}

	public String getDeck() {
		return deck;
	}

	public void setDeck(String deck) {
		this.deck = deck;
	}

	public String getOpponentDeck() {
		return opponentDeck;
	}

	public void setOpponentDeck(String opponentDeck) {
		this.opponentDeck = opponentDeck;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Game() {};
	
	public Game(int id, String opponentName, Integer gameWins, Integer gameLosses, Integer gameDraws, String deck,
			String opponentDeck) {
		super();
		this.id = id;
		this.opponentName = opponentName;
		this.gameWins = gameWins;
		this.gameLosses = gameLosses;
		this.gameDraws = gameDraws;
		this.deck = deck;
		this.opponentDeck = opponentDeck;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", opponentName=" + opponentName + ", gameWins=" + gameWins + ", gameLosses="
				+ gameLosses + ", gameDraws=" + gameDraws + ", deck=" + deck + ", opponentDeck=" + opponentDeck + "]";
	}
	
	
	
	
	

	
	
	
}
