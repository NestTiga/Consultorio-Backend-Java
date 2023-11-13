package com.tigasinestor.pruebapractica.dao;

import com.tigasinestor.pruebapractica.model.Medico;

public interface LoginDao {
    Medico datosDeUsuarioPorCredenciales(Medico medico);
}
