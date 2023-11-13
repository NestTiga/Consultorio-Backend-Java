package com.tigasinestor.pruebapractica.dao;

import com.tigasinestor.pruebapractica.model.Medico;

import java.util.List;

public interface MedicoDao {
    List<Medico> getMedicos();

    boolean registrarMedico(Medico medico);
}
