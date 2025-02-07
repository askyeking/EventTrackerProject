package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Band;
import com.skilldistillery.eventtracker.entities.Vinyl;
import com.skilldistillery.eventtracker.services.BandService;
import com.skilldistillery.eventtracker.services.VinylService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class BandController {

	@Autowired
	private BandService bandService;
	
	@Autowired
	private VinylService vinylService;
	@GetMapping("bands")
	public List<Band> findAll() {
		return bandService.findAll();
	}
	
	@GetMapping("bands/{bandId}/vinyls")
	public List<Vinyl> getVinylsByBandId(@PathVariable("bandId") int bandId, HttpServletResponse resp) {
		List<Vinyl> bandVinyls = vinylService.findByBandId(bandId);
		if(bandVinyls == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return bandVinyls;
	}
	
	
	
}
