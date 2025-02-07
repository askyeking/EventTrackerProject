package com.skilldistillery.eventtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Band;

public interface BandRepository extends JpaRepository<Band, Integer>{

}
