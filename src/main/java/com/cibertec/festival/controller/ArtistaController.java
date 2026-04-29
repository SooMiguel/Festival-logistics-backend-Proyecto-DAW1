package com.cibertec.festival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.festival.service.ArtistaService;

@Controller
@RequestMapping("/artista")
public class ArtistaController {
	@Autowired
	private ArtistaService artistaService;
}
