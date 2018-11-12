package com.skilldistillery.mtggametracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GameTest {
	
	private static 	EntityManagerFactory emf;
	EntityManager em;


	@BeforeAll
	public static void setUpAll(){
		emf = Persistence.createEntityManagerFactory("mtggametracker");
	}
	@AfterAll
	public static void tearDownAll() {
		emf.close();
	}
	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}
	@AfterEach
	void tearDown() throws Exception {
		em.close();	
	}

	@Test
	void testGameEntityMapping() {
		Game game = em.find(Game.class, 1);
		assertEquals("Affinity",game.getOpponentDeck());
		assertEquals("Fish", game.getDeck());
		assertEquals(1 , game.getGameWins().intValue());
		assertEquals(2, game.getGameLosses().intValue());
	}

}
