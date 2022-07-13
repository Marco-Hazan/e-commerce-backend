package com.aizoon.project.service;

import com.aizoon.project.dto.request.UtenteRequestDto;
import com.aizoon.project.dto.response.UtenteResponseDto;
import com.aizoon.project.model.ERole;
import com.aizoon.project.model.Utente;
import com.aizoon.project.repository.RoleRepository;
import com.aizoon.project.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    UtenteRepository repo;

    @Autowired
    RoleRepository repoRole;

    @Autowired
    PasswordEncoder encoder;

    public UtenteResponseDto save(UtenteRequestDto req){
        if (repo.existsByUsername(req.getUsername())) {
            throw new RuntimeException("L'utente è gia stato trovato");
        }
        if (repo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("L'utente è gia stato trovato");
        }
        Utente utente = new Utente();
        utente.copyFrom(req);
        utente.setPassword(encoder.encode(req.getPassword()));
        utente.setRuolo(repoRole.findByNome(ERole.USER));
        return repo.save(utente).copyTo();
    }

}
