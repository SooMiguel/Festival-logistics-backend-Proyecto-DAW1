package com.cibertec.festival.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Integer idArtista;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "genero_musical", length = 50)
    private String generoMusical;
    
    @Column(name = "rider_tecnico", columnDefinition = "TEXT")
    private String riderTecnico;
}