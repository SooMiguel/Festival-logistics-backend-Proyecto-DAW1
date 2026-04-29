package com.cibertec.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.festival.models.Presentacion;
import com.cibertec.festival.repository.PresentacionRepository;

@Service
public class PresentacionService {
	@Autowired
	private PresentacionRepository presentacionRepository;
	
	public List<Presentacion> getPresentaciones(){
		return presentacionRepository.findAll();
	}
}
