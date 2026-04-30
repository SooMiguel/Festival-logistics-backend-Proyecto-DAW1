package com.cibertec.festival.mappers;

import com.cibertec.festival.dto.PresentacionRequestDto;
import com.cibertec.festival.dto.PresentacionResponseDto;
import com.cibertec.festival.models.Presentacion;

public class PresentacionMapper {
	public PresentacionResponseDto toPresentacionResponse(Presentacion presentacion) {
		PresentacionResponseDto dto = new PresentacionResponseDto();
		dto.setIdPresentacion(presentacion.getIdPresentacion());
		dto.setArtista(presentacion.getArtista());
		dto.setEscenario(presentacion.getEscenario());
		dto.setFechaPresentacion(presentacion.getFechaPresentacion());
		dto.setHoraInicio(presentacion.getHoraInicio());
		dto.setHoraFin(presentacion.getHoraFin());
		return dto;
	}
	
	public Presentacion toPresentacion(PresentacionRequestDto dto) {
		Presentacion entity = new Presentacion();
		entity.setArtista(dto.getArtista());
		entity.setEscenario(dto.getEscenario());
		entity.setFechaPresentacion(dto.getFechaPresentacion());
		entity.setHoraInicio(dto.getHoraInicio());
		entity.setHoraFin(dto.getHoraFin());
		return entity;
	}
}
