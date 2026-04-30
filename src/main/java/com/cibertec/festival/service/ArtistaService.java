package com.cibertec.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.festival.dto.ArtistaRequestDto;
import com.cibertec.festival.dto.ArtistaResponseDto;
import com.cibertec.festival.mappers.ArtistaMapper;
import com.cibertec.festival.models.Artista;
import com.cibertec.festival.repository.ArtistaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ArtistaService {
	@Autowired
	private ArtistaRepository artistaRepository;
	
	private ArtistaMapper mapper = new ArtistaMapper();
	
	public List<ArtistaResponseDto> getAll() {
		List<Artista> artistas = artistaRepository.findAll();
		return artistas.stream().map(mapper::toArtistaResponse).toList();
	}
	
	public ArtistaResponseDto getArtista(Integer id) {
		return mapper.toArtistaResponse(artistaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Artista no encontrado")));			
	}
	
	public ArtistaResponseDto addArtista(ArtistaRequestDto dto) {
		Artista artista = mapper.toArtista(dto);
		Artista nuevo = artistaRepository.save(artista);
		return mapper.toArtistaResponse(nuevo);
	}
	
	public ArtistaResponseDto editArtista(Integer id, ArtistaRequestDto dto) {
		Artista actual = artistaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Artista no encontrado"));
		actual.setNombre(dto.getNombre());
		actual.setGeneroMusical(dto.getGeneroMusical());
		actual.setRiderTecnico(dto.getRiderTecnico());
		Artista actualizado = artistaRepository.save(actual);
		return mapper.toArtistaResponse(actualizado);
	}
	
	public void removeArtista(Integer id) {
		artistaRepository.deleteById(id);
	}
}
