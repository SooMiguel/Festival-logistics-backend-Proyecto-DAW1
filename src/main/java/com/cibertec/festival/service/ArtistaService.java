package com.cibertec.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.festival.models.Artista;
import com.cibertec.festival.repository.ArtistaRepository;

@Service
public class ArtistaService {
	@Autowired
	private ArtistaRepository artistaRepository;
	
	public List<Artista> getArtistas() {
		return artistaRepository.findAll();
	}
	
	
}
