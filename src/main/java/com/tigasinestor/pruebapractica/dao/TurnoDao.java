package com.tigasinestor.pruebapractica.dao;

import com.tigasinestor.pruebapractica.model.Turno;

import java.util.List;

public interface TurnoDao {
    List<Turno> getTurnos();

    void registrarTurno(Turno turno);

    boolean actualizarTurno(Turno turno);

    List<Turno> getTurnosDespachados();
}
