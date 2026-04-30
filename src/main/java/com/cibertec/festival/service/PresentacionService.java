package com.cibertec.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.festival.dto.PresentacionRequestDto;
import com.cibertec.festival.dto.PresentacionResponseDto;
import com.cibertec.festival.mappers.PresentacionMapper;
import com.cibertec.festival.models.Presentacion;
import com.cibertec.festival.repository.PresentacionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PresentacionService {
	@Autowired
	private PresentacionRepository presentacionRepository;
	
	private PresentacionMapper mapper = new PresentacionMapper();
	
	public List<PresentacionResponseDto> getAll() {
		List<Presentacion> presentaciones = presentacionRepository.findAll();
		return presentaciones.stream().map(mapper::toPresentacionResponse).toList();
	}
	
	public PresentacionResponseDto getPresentacion(Integer id) {
		return mapper.toPresentacionResponse(presentacionRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Presentacion no encontrada")));			
	}
	
	public PresentacionResponseDto addPresentacion(PresentacionRequestDto dto) {
		Presentacion presentacion = mapper.toPresentacion(dto);
		Presentacion nuevo = presentacionRepository.save(presentacion);
		return mapper.toPresentacionResponse(nuevo);
	}
	
	public PresentacionResponseDto editPresentacion(Integer id, PresentacionRequestDto dto) {
		Presentacion actual = presentacionRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Presentacion no encontrada"));
		actual.setArtista(dto.getArtista());
		actual.setEscenario(dto.getEscenario());
		actual.setFechaPresentacion(dto.getFechaPresentacion());
		actual.setHoraInicio(dto.getHoraInicio());
		actual.setHoraFin(dto.getHoraFin());
		Presentacion actualizado = presentacionRepository.save(actual);
		return mapper.toPresentacionResponse(actualizado);
	}
	
	public void removePresentacion(Integer id) {
		presentacionRepository.deleteById(id);
	}
}
