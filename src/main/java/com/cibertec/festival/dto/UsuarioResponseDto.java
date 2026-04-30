package com.cibertec.festival.dto;

public class UsuarioResponseDto {
	//Atributos
	private Integer idUsuario;
    private String username;
    private String password;
    private String rol;
    
    //Constructor
	public UsuarioResponseDto() {}

    //Getters & Setters
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
}
