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

import com.cibertec.festival.dto.PresentacionRequestDto;
import com.cibertec.festival.dto.PresentacionResponseDto;
import com.cibertec.festival.service.PresentacionService;

@RestController
@RequestMapping("/api/presentacion")
public class PresentacionController {
	@Autowired
	private PresentacionService service;

	@GetMapping("/{idPresentacion}")
	public PresentacionResponseDto getPresentacion(Integer id) {
		return service.getPresentacion(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addPresentacion(@RequestBody PresentacionRequestDto dto){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.addPresentacion(dto));
	}
	
	@PutMapping("/{idPresentacion}")
	public ResponseEntity<?> editPresentacion(@PathVariable Integer idPresentacion, @RequestBody PresentacionRequestDto dto) {
		return ResponseEntity.ok(service.editPresentacion(idPresentacion, dto));
	}
	
	@DeleteMapping("/{idPresentacion}")
	public ResponseEntity<?> removePresentacion(@PathVariable Integer idPresentacion){
		service.removePresentacion(idPresentacion);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
