package com.cibertec.festival.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Integer idEquipo;
    
    @Column(nullable = false, length = 50)
    private String tipo;
    
    @Column(nullable = false, length = 150)
    private String descripcion;
    
    @Column(name = "cantidad_disponible", nullable = false)
    private Integer cantidadDisponible;
}