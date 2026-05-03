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

import com.cibertec.festival.dto.ArtistaRequestDto;
import com.cibertec.festival.dto.ArtistaResponseDto;
import com.cibertec.festival.service.ArtistaService;

@RestController
@RequestMapping("/api/artista")
public class ArtistaController {
	@Autowired
	private ArtistaService service;
	
	@GetMapping
	public List<ArtistaResponseDto> listarArtistas() {
	    return service.getAll();
	}
	
	@GetMapping("/{idArtista}")
	public ArtistaResponseDto getArtista(Integer id) {
		return service.getArtista(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addArtista(@RequestBody ArtistaRequestDto dto){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.addArtista(dto));
	}
	
	@PutMapping("/{idArtista}")
	public ResponseEntity<?> editArtista(@PathVariable Integer idArtista, @RequestBody ArtistaRequestDto dto) {
		return ResponseEntity.ok(service.editArtista(idArtista, dto));
	}
	
	@DeleteMapping("/{idArtista}")
	public ResponseEntity<?> removeArtista(@PathVariable Integer idArtista){
		service.removeArtista(idArtista);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
