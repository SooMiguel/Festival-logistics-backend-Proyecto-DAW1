package com.cibertec.festival.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "escenarios")
public class Escenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escenario")
    private Integer idEscenario;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false)
    private Integer capacidad;
}