package com.cibertec.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.festival.dto.EscenarioRequestDto;
import com.cibertec.festival.dto.EscenarioResponseDto;
import com.cibertec.festival.mappers.EscenarioMapper;
import com.cibertec.festival.models.Escenario;
import com.cibertec.festival.repository.EscenarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EscenarioService {
	@Autowired
	private EscenarioRepository escenarioRepository;
	
	private EscenarioMapper mapper = new EscenarioMapper();
	
	public List<EscenarioResponseDto> getAll() {
		List<Escenario> escenarios = escenarioRepository.findAll();
		return escenarios.stream().map(mapper::toEscenarioResponse).toList();
	}
	
	public EscenarioResponseDto getEscenario(Integer id) {
		return mapper.toEscenarioResponse(escenarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Escenario no encontrado")));			
	}
	
	public EscenarioResponseDto addEscenario(EscenarioRequestDto dto) {
		Escenario escenario = mapper.toEscenario(dto);
		Escenario nuevo = escenarioRepository.save(escenario);
		return mapper.toEscenarioResponse(nuevo);
	}
	
	public EscenarioResponseDto editEscenario(Integer id, EscenarioRequestDto dto) {
		Escenario actual = escenarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Escenario no encontrado"));
		actual.setNombre(dto.getNombre());
		actual.setCapacidad(dto.getCapacidad());
		Escenario actualizado = escenarioRepository.save(actual);
		return mapper.toEscenarioResponse(actualizado);
	}
	
	public void removeEscenario(Integer id) {
		escenarioRepository.deleteById(id);
	}
}
