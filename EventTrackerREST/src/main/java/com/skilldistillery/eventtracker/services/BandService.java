package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Band;

public interface BandService {
	
	List<Band> findAll();
	Band findById(int bandId);
	Band create(Band band);
	Band update(Band band, int bandId);
	boolean delete(int bandId);

}
