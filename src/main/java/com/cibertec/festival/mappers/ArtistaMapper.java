package com.cibertec.festival.mappers;

import org.springframework.stereotype.Component;

import com.cibertec.festival.dto.ArtistaRequestDto;
import com.cibertec.festival.dto.ArtistaResponseDto;
import com.cibertec.festival.models.Artista;

@Component
public class ArtistaMapper {
	public ArtistaResponseDto toArtistaResponse(Artista artista) {
		ArtistaResponseDto dto = new ArtistaResponseDto();		
		dto.setIdArtista(artista.getIdArtista());
		dto.setNombre(artista.getNombre());
		dto.setGeneroMusical(artista.getGeneroMusical());
		dto.setRiderTecnico(artista.getRiderTecnico());		
		return dto;
	}
	
	public Artista toArtista(ArtistaRequestDto dto) {
		Artista entity = new Artista();
		entity.setNombre(dto.getNombre());
		entity.setGeneroMusical(dto.getGeneroMusical());
		entity.setRiderTecnico(dto.getRiderTecnico());
		return entity;
	}
}
