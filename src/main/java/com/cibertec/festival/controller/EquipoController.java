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

import com.cibertec.festival.dto.EquipoRequestDto;
import com.cibertec.festival.dto.EquipoResponseDto;
import com.cibertec.festival.service.EquipoService;

@RestController
@RequestMapping("/equipo")
public class EquipoController {
	@Autowired
	private EquipoService service;
	
	@GetMapping
	public List<EquipoResponseDto> listarEquipos() {
	    return service.getAll();
	}
	
	
	@GetMapping("/{idEquipo}")
	public EquipoResponseDto getEquipo(Integer id) {
		return service.getEquipo(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addEquipo(@RequestBody EquipoRequestDto dto){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.addEquipo(dto));
	}
	
	@PutMapping("/{idEquipo}")
	public ResponseEntity<?> editEquipo(@PathVariable Integer idEquipo, @RequestBody EquipoRequestDto dto) {
		return ResponseEntity.ok(service.editEquipo(idEquipo, dto));
	}
	
	@DeleteMapping("/{idEquipo}")
	public ResponseEntity<?> removeEquipo(@PathVariable Integer idEquipo){
		service.removeEquipo(idEquipo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
