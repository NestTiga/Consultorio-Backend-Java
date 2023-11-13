package com.tigasinestor.pruebapractica.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name="turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre", length = 25)
    private String nombre;

    @Column(name="apellido", length = 25)
    private String apellido;

    @Column(name="cedula", length = 10)
    private String cedula;

    @Column(name="especialidad", length = 50)
    private String especialidad;

    @Column(name="sintomas", length = 255)
    private String sintomas;

    @Column(name="observacion", length = 255)
    private String observacion;

    @Column(name="comentario", length = 255)
    private String comentario;

    @Column(name="receta", length = 255)
    private String receta;

    @Column(name="archivo", length = 255)
    private String archivo;

    @Column(name="estado", length = 50)
    private String estado;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;


}
