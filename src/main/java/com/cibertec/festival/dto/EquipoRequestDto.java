package com.cibertec.festival.dto;

public class EquipoRequestDto {
	//Atributos
    private String tipo;
    private String descripcion;
    private Integer cantidadDisponible;
    
    //Constructor
	public EquipoRequestDto() {	}

	//Getters & Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
    
    
}
