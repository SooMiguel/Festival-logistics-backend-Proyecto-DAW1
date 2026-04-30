package com.cibertec.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.festival.dto.EquipoRequestDto;
import com.cibertec.festival.dto.EquipoResponseDto;
import com.cibertec.festival.mappers.EquipoMapper;
import com.cibertec.festival.models.Equipo;
import com.cibertec.festival.repository.EquipoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipoService {
	@Autowired
	private EquipoRepository equipoRepository;
	
	private EquipoMapper mapper = new EquipoMapper();
	
	public List<EquipoResponseDto> getAll() {
		List<Equipo> equipos = equipoRepository.findAll();
		return equipos.stream().map(mapper::toEquipoResponse).toList();
	}
	
	public EquipoResponseDto getEquipo(Integer id) {
		return mapper.toEquipoResponse(equipoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado")));			
	}
	
	public EquipoResponseDto addEquipo(EquipoRequestDto dto) {
		Equipo equipo = mapper.toEquipo(dto);
		Equipo nuevo = equipoRepository.save(equipo);
		return mapper.toEquipoResponse(nuevo);
	}
	
	public EquipoResponseDto editEquipo(Integer id, EquipoRequestDto dto) {
		Equipo actual = equipoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado"));
		actual.setTipo(dto.getTipo());
		actual.setDescripcion(dto.getDescripcion());
		actual.setCantidadDisponible(dto.getCantidadDisponible());
		Equipo actualizado = equipoRepository.save(actual);
		return mapper.toEquipoResponse(actualizado);
	}
	
	public void removeEquipo(Integer id) {
		equipoRepository.deleteById(id);
	}
}
