package com.tigasinestor.pruebapractica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre", length = 25)
    private String nombre;

    @Column(name="correo", length = 255)
    private String correo;

    @Column(name="contrasenia", length = 255)
    private String contrasenia;
}
