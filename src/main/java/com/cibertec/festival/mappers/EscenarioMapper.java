package com.cibertec.festival.mappers;

import org.springframework.stereotype.Component;

import com.cibertec.festival.dto.EscenarioRequestDto;
import com.cibertec.festival.dto.EscenarioResponseDto;
import com.cibertec.festival.models.Escenario;

@Component
public class EscenarioMapper {
	public EscenarioResponseDto toEscenarioResponse(Escenario escenario) {
		EscenarioResponseDto dto = new EscenarioResponseDto();
		dto.setIdEscenario(escenario.getIdEscenario());
		dto.setNombre(escenario.getNombre());
		dto.setCapacidad(escenario.getCapacidad());
		return dto;
	}
	
	public Escenario toEscenario(EscenarioRequestDto dto) {
		Escenario entity = new Escenario();
		entity.setNombre(dto.getNombre());
		entity.setCapacidad(dto.getCapacidad());
		return entity;
	}
}
