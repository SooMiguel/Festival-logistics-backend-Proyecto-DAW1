package com.cibertec.festival.dto;

public class EquipoResponseDto {
	//Constructores
    private Integer idEquipo;
    private String tipo;
    private String descripcion;
    private Integer cantidadDisponible;
    
    //Constructor
	public EquipoResponseDto() {}
	
	//Getters & Setters
	public Integer getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}
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
