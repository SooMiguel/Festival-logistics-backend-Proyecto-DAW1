package com.cibertec.festival.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.festival.dto.EscenarioRequestDto;
import com.cibertec.festival.dto.EscenarioResponseDto;
import com.cibertec.festival.service.EscenarioService;

@RestController
@RequestMapping("/api/escenario")
public class EscenarioController {
	@Autowired
	private EscenarioService service;
	
	@GetMapping
	public List<EscenarioResponseDto> listarEscenarios() {
	    return service.getAll();
	}
	
	
	@GetMapping("/{idEscenario}")
	public EscenarioResponseDto getEscenario(Integer id) {
		return service.getEscenario(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addEscenario(@RequestBody EscenarioRequestDto dto){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.addEscenario(dto));
	}
	
	@PutMapping("/{idEscenario}")
	public ResponseEntity<?> editEscenario(@PathVariable Integer idEscenario, @RequestBody EscenarioRequestDto dto) {
		return ResponseEntity.ok(service.editEscenario(idEscenario, dto));
	}
	
	@DeleteMapping("/{idEscenario}")
	public ResponseEntity<?> removeEscenario(@PathVariable Integer idEscenario){
		service.removeEscenario(idEscenario);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
