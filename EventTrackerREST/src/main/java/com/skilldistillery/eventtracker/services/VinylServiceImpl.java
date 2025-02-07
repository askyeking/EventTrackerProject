package com.skilldistillery.eventtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Vinyl;
import com.skilldistillery.eventtracker.repositories.BandRepository;
import com.skilldistillery.eventtracker.repositories.VinylRepository;

@Service
public class VinylServiceImpl implements VinylService {

	@Autowired
	private VinylRepository vinylRepo;

	@Autowired
	private BandRepository bandRepo;

	@Override
	public List<Vinyl> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vinyl findById(int vinylId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vinyl create(Vinyl vinyl, int bandId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vinyl update(Vinyl vinyl, int vinylId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int vinylId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Vinyl> findByBandName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vinyl> findByBandId(int bandId) {
		if (!bandRepo.existsById(bandId)) {
			return null;
		}
		return vinylRepo.findByBandId(bandId);

	}

}
