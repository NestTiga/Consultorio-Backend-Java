package com.tigasinestor.pruebapractica.dao;

import com.tigasinestor.pruebapractica.model.Medico;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LoginDaoImp implements LoginDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Medico datosDeUsuarioPorCredenciales(Medico medico) {
        String query="FROM Medico WHERE correo= :correo";
        List<Medico> lista= entityManager.createQuery(query)
                .setParameter("correo",medico.getCorreo())
                .getResultList();

        if (lista.isEmpty()){
            return null;
        }
        String contraCodificada=lista.get(0).getContrasenia();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(contraCodificada, medico.getContrasenia())){
            return lista.get(0);
        }
        return null;
    }
}
