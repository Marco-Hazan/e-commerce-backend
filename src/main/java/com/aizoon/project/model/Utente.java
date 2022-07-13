package com.aizoon.project.model;

import com.aizoon.project.dto.request.UtenteRequestDto;
import com.aizoon.project.dto.response.UtenteResponseDto;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "utenti")
public class Utente implements IEntity<UtenteRequestDto, UtenteResponseDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_ruolo")
    private Role ruolo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRuolo() {
        return ruolo;
    }

    public void setRuolo(Role ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public UtenteResponseDto copyTo() {
        UtenteResponseDto dto = new UtenteResponseDto();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }

    @Override
    public void copyFrom(UtenteRequestDto req) {
        BeanUtils.copyProperties(req,this);
    }
}
