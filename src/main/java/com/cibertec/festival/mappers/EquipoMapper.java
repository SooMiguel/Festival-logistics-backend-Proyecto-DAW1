package com.cibertec.festival.mappers;

import org.springframework.stereotype.Component;

import com.cibertec.festival.dto.EquipoRequestDto;
import com.cibertec.festival.dto.EquipoResponseDto;
import com.cibertec.festival.models.Equipo;

@Component
public class EquipoMapper {
	public EquipoResponseDto toEquipoResponse(Equipo equipo) {
		EquipoResponseDto dto = new EquipoResponseDto();
		dto.setIdEquipo(equipo.getIdEquipo());
		dto.setDescripcion(equipo.getDescripcion());
		dto.setTipo(equipo.getTipo());
		dto.setCantidadDisponible(equipo.getCantidadDisponible());
		return dto;
	}
	
	public Equipo toEquipo(EquipoRequestDto dto) {
		Equipo entity = new Equipo();
		entity.setDescripcion(dto.getDescripcion());
		entity.setTipo(dto.getTipo());
		entity.setCantidadDisponible(dto.getCantidadDisponible());
		return entity;
	}
}
