package com.cibertec.festival.mappers;

import com.cibertec.festival.dto.UsuarioRequestDto;
import com.cibertec.festival.dto.UsuarioResponseDto;
import com.cibertec.festival.models.Usuario;

public class UsuarioMapper {
	public UsuarioResponseDto toUsuarioResponse(Usuario usuario) {
		UsuarioResponseDto dto = new UsuarioResponseDto();
		dto.setUsername(usuario.getUsername());
		dto.setPassword(usuario.getPassword());
		dto.setRol(usuario.getRol());
		return dto;
	}
	
	public Usuario toUsuario(UsuarioRequestDto dto) {
		Usuario entity = new Usuario();
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		entity.setRol(dto.getRol());
		return entity;
	}
}
