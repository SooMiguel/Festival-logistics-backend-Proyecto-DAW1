package com.cibertec.festival.controller;

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

import com.cibertec.festival.dto.UsuarioRequestDto;
import com.cibertec.festival.dto.UsuarioResponseDto;
import com.cibertec.festival.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/{idUsuario}")
	public UsuarioResponseDto getUsuario(Integer id) {
		return service.getUsuario(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addUsuario(@RequestBody UsuarioRequestDto dto){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.addUsuario(dto));
	}
	
	@PutMapping("/{idUsuario}")
	public ResponseEntity<?> editUsuario(@PathVariable Integer idUsuario, @RequestBody UsuarioRequestDto dto) {
		return ResponseEntity.ok(service.editUsuario(idUsuario, dto));
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<?> removeUsuario(@PathVariable Integer idUsuario){
		service.removeUsuario(idUsuario);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
