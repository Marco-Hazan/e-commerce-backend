package com.aizoon.project.controller;

import com.aizoon.project.dto.request.LoginRequest;
import com.aizoon.project.dto.request.UtenteRequestDto;
import com.aizoon.project.dto.response.JwtResponse;
import com.aizoon.project.dto.response.UtenteResponseDto;
import com.aizoon.project.model.Utente;
import com.aizoon.project.security.jwt.JwtUtils;
import com.aizoon.project.security.services.UserDetailsImpl;
import com.aizoon.project.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {


    @Autowired
    UtenteService userService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtUtils jwtUtils;

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
        String jwt = jwtUtils.generateJwtToken(auth);
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        List<String> roles = auth.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles
        ));
    }


}
