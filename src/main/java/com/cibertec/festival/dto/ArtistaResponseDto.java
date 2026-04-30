package com.cibertec.festival.dto;

public class ArtistaResponseDto {
	//Atributos
	private Integer idArtista;
	private String nombre;    
    private String generoMusical;    
    private String riderTecnico;
	   
    //Constructor
    public ArtistaResponseDto() {}
 
    //Getters & Setters
    public Integer getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(Integer idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public String getRiderTecnico() {
		return riderTecnico;
	}

	public void setRiderTecnico(String riderTecnico) {
		this.riderTecnico = riderTecnico;
	}
    
}
