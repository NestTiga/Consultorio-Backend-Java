package com.tigasinestor.pruebapractica.controllers;

import com.tigasinestor.pruebapractica.dao.TurnoDao;
import com.tigasinestor.pruebapractica.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurnoController {

    @Autowired
    private TurnoDao turnoDao;


    @GetMapping(value = "api/turnos/pendientes")
    public List<Turno> getTrunos(){
        return turnoDao.getTurnos();
    }

    @GetMapping(value = "api/turnos/despachados")
    public List<Turno> getTrunosDespachados(){
        return turnoDao.getTurnosDespachados();
    }

    @PostMapping(value = "api/turnos")
    public boolean postTurno(@RequestBody Turno turno){
        turnoDao.registrarTurno(turno);
        return true;
    }

    @PutMapping(value = "api/turnos")
    public boolean putTurno(@RequestBody Turno turno){

        return turnoDao.actualizarTurno(turno);
    }
}
