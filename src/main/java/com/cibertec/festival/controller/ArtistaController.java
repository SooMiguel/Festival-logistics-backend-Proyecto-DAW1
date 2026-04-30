package com.cibertec.festival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.festival.service.ArtistaService;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
	@Autowired
	private ArtistaService service;
	
	
}
