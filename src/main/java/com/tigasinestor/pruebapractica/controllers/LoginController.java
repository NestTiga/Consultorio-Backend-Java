package com.tigasinestor.pruebapractica.controllers;

import com.tigasinestor.pruebapractica.dao.LoginDao;
import com.tigasinestor.pruebapractica.model.Medico;
import com.tigasinestor.pruebapractica.security.JWTSecurity;
import com.tigasinestor.pruebapractica.security.TokenM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private JWTSecurity jwtSecurity;

    @Autowired
    private TokenM tokenM;


    @PostMapping(value = "api/login")
    public TokenM login(@RequestBody Medico medico){

        Medico usuarioLogueado= loginDao.datosDeUsuarioPorCredenciales(medico);
        if (usuarioLogueado!=null){
            String token= jwtSecurity.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getNombre());
            tokenM.setToken(token);
            tokenM.setEstado(true);
            return tokenM;
        }
        tokenM.setToken(null);
        tokenM.setEstado(false);
        return tokenM;

    }
}
