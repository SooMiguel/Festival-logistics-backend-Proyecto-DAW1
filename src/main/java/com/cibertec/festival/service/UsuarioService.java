package com.cibertec.festival.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.festival.dto.UsuarioRequestDto;
import com.cibertec.festival.dto.UsuarioResponseDto;
import com.cibertec.festival.mappers.UsuarioMapper;
import com.cibertec.festival.models.Usuario;
import com.cibertec.festival.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
private UsuarioMapper mapper = new UsuarioMapper();
	
	public List<UsuarioResponseDto> getAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(mapper::toUsuarioResponse).toList();
	}
	
	public UsuarioResponseDto getUsuario(Integer id) {
		return mapper.toUsuarioResponse(usuarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado")));			
	}
	
	public UsuarioResponseDto addUsuario(UsuarioRequestDto dto) {
		Usuario usuario = mapper.toUsuario(dto);
		Usuario nuevo = usuarioRepository.save(usuario);
		return mapper.toUsuarioResponse(nuevo);
	}
	
	public UsuarioResponseDto editUsuario(Integer id, UsuarioRequestDto dto) {
		Usuario actual = usuarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
		actual.setUsername(dto.getUsername());
		actual.setPassword(dto.getPassword());
		actual.setRol(dto.getRol());
		Usuario actualizado = usuarioRepository.save(actual);
		return mapper.toUsuarioResponse(actualizado);
	}
	
	public void removeUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	}
}
