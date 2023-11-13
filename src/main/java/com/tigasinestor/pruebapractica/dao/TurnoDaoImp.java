package com.tigasinestor.pruebapractica.dao;


import com.tigasinestor.pruebapractica.model.Turno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TurnoDaoImp implements TurnoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Turno> getTurnos() {
        String query="FROM Turno WHERE estado <> 'Despachado'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrarTurno(Turno turno) {
        entityManager.merge(turno);
    }

    @Override
    public boolean actualizarTurno(Turno turno) {
        Turno datoActual=entityManager.find(Turno.class,turno.getId());
        if(datoActual==null){
            return false;
        }
        datoActual.setNombre(turno.getNombre());
        datoActual.setApellido(turno.getApellido());
        datoActual.setCedula(turno.getCedula());
        datoActual.setEspecialidad(turno.getEspecialidad());
        datoActual.setSintomas(turno.getSintomas());
        datoActual.setObservacion(turno.getObservacion());
        datoActual.setComentario(turno.getComentario());
        datoActual.setReceta(turno.getReceta());
        datoActual.setArchivo(turno.getArchivo());
        datoActual.setEstado(turno.getEstado());
        return true;
    }

    @Override
    public List<Turno> getTurnosDespachados() {
        String query="FROM Turno WHERE estado <> 'Pendiente'";
        return entityManager.createQuery(query).getResultList();
    }


}
