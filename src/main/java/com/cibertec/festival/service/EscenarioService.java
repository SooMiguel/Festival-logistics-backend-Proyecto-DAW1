package com.cibertec.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.festival.models.Escenario;
import com.cibertec.festival.repository.EscenarioRepository;

@Service
public class EscenarioService {
	@Autowired
	private EscenarioRepository escenarioRepository;
	
	public List<Escenario> getEscenarios(){
		return escenarioRepository.findAll();
	}
}
