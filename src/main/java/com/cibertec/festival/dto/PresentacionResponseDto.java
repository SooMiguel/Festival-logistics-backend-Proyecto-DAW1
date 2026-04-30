package com.cibertec.festival.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cibertec.festival.models.Artista;
import com.cibertec.festival.models.Escenario;

public class PresentacionResponseDto {
	//Atributos
	private Integer idPresentacion;
    private Artista artista;
    private Escenario escenario;
    private LocalDate fechaPresentacion;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    //Constructor
    public PresentacionResponseDto() {}

    //Getters & Setters
	public Integer getIdPresentacion() {
		return idPresentacion;
	}

	public void setIdPresentacion(Integer idPresentacion) {
		this.idPresentacion = idPresentacion;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	public LocalDate getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(LocalDate fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
    
}
