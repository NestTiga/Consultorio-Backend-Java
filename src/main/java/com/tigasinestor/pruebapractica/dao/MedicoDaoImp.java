package com.tigasinestor.pruebapractica.dao;


import com.tigasinestor.pruebapractica.model.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MedicoDaoImp implements MedicoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Medico> getMedicos() {
        String query="FROM Medico";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public boolean registrarMedico(Medico medico) {
        entityManager.merge(medico);
        return true;
    }
}
