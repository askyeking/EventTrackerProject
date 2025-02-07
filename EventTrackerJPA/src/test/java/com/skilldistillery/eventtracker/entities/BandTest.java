package com.skilldistillery.eventtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class BandTest {
	

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Band band;
	
	
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
	    band = em.find(Band.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
	    em.close();
	}
	
	@Test
	void test_band_basic_mappings() {
		assertEquals("Cap'N Jazz",band.getName());
	}
	
	@Test
	void test_band_has_vinyls() {
		assertNotNull(band.getVinyls());
		assertTrue(band.getVinyls().size() > 0);
	}
	
}
