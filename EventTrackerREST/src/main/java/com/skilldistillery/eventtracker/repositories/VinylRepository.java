package com.skilldistillery.eventtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Vinyl;

public interface VinylRepository extends JpaRepository<Vinyl, Integer>{
	
	List<Vinyl> findByBandName(String name);
	List<Vinyl> findByBandId(int bandId);

}
