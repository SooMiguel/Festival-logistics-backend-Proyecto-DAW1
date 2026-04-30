package com.cibertec.festival.dto;

public class EscenarioRequestDto {
	//Atributos
    private String nombre;
    private Integer capacidad;
    
    //Constructor
	public EscenarioRequestDto() {	}

	//Getters & Setters
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
