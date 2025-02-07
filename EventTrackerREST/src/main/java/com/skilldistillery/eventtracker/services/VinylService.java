package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Vinyl;

public interface VinylService {
	
	List<Vinyl> findAll();
	Vinyl findById(int vinylId);
	Vinyl create(Vinyl vinyl, int bandId);
	Vinyl update(Vinyl vinyl, int vinylId);
	boolean delete(int vinylId);
	List<Vinyl> findByBandName(String name);
	List<Vinyl> findByBandId(int bandId);

}
