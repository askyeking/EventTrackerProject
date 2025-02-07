package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Band;
import com.skilldistillery.eventtracker.repositories.BandRepository;

@Service
public class BandServiceImpl implements BandService{
	
	@Autowired
	private BandRepository bandRepo;

	@Override
	public List<Band> findAll() {
		return bandRepo.findAll();
	}

	@Override
	public Band findById(int bandId) {
		Band foundBand =  bandRepo.findById(bandId).orElse(null);
		return foundBand;
	}

	@Override
	public Band create(Band band) {
		bandRepo.saveAndFlush(band);
		return band;
	}

	@Override
	public Band update(Band band, int bandId) {
		Band managedBand =  bandRepo.findById(bandId).orElse(null);
		managedBand.setImageUrl(band.getImageUrl());
		managedBand.setName(band.getName());
		return managedBand;
	}

	@Override
	public boolean delete(int bandId) {
		boolean deleted = false;
		if(bandRepo.existsById(bandId)) {
			bandRepo.deleteById(bandId);
			deleted = true;
		}
		return deleted;
	}
	
	

}
