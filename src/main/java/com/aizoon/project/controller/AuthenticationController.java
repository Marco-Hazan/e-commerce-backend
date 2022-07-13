package com.aizoon.project.controller;

import com.aizoon.project.dto.request.LoginRequest;
import com.aizoon.project.dto.request.UtenteRequestDto;
import com.aizoon.project.dto.response.JwtResponse;
import com.aizoon.project.dto.response.UtenteResponseDto;
import com.aizoon.project.model.Utente;
import com.aizoon.project.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {


    @Autowired
    UtenteService userService;

    @Autowired
    AuthenticationManager authManager;

    @PostMapping("/signup")
    public ResponseEntity<UtenteResponseDto> register(@RequestBody UtenteRequestDto req){
        return ResponseEntity.ok(userService.save(req));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req){
        Authentication auth = authManager.authenticate( new UsernamePasswordAuthenticationToken(
                req.getUsername(), req.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtUtil.generateJwtToken(authentication);
    }


}
