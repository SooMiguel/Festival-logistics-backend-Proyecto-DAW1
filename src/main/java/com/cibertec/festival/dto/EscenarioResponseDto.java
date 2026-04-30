package com.cibertec.festival.dto;

public class EscenarioResponseDto {
	//Atributos
	private Integer idEscenario;
    private String nombre;
    private Integer capacidad;
    
    //Constructor
	public EscenarioResponseDto() {	}

	//Getters & Setters
	public Integer getIdEscenario() {
		return idEscenario;
	}

	public void setIdEscenario(Integer idEscenario) {
		this.idEscenario = idEscenario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
    
	
}
