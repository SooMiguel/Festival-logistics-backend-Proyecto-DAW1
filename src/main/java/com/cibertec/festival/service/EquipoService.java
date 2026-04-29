package com.cibertec.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.festival.models.Equipo;
import com.cibertec.festival.repository.EquipoRepository;

@Service
public class EquipoService {
	@Autowired
	private EquipoRepository equipoRepository;
	
	public List<Equipo> getEquipos() {
		return equipoRepository.findAll();
	}
}
