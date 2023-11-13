package com.tigasinestor.pruebapractica.controllers;


import com.tigasinestor.pruebapractica.dao.MedicoDao;
import com.tigasinestor.pruebapractica.model.Medico;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    private MedicoDao medicoDao;

    @GetMapping(value = "api/medicos")
    public List<Medico> getMedicos(){
        return medicoDao.getMedicos();
    }

    @PostMapping(value = "api/medicos")
    public boolean postMedico(@RequestBody Medico medico){
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String codificado= argon2.hash(1, 1024, 1,medico.getContrasenia());
        medico.setContrasenia(codificado);
        return medicoDao.registrarMedico(medico);
    }
}
