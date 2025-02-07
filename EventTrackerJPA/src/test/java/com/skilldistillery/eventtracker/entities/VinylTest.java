package com.skilldistillery.eventtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class VinylTest {
	

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Vinyl vinyl;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	    emf = Persistence.createEntityManagerFactory("EventTrackerJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	    emf.close();
	}
	
	@BeforeEach
	void setUp() throws Exception {
	    em = emf.createEntityManager();
	    vinyl = em.find(Vinyl.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	    em.close();
	}
	
	@Test
	void test_vinyl_basic_mappings() {
		assertEquals("Analphabetapolothology",vinyl.getTitle());
	}
	
	@Test
	void test_vinyl_has_band() {
		assertNotNull(vinyl.getBand());
	}
	
}
