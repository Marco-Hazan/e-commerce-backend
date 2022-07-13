package com.aizoon.project.model;

import javax.persistence.*;

@Entity
@Table(name = "ruoli")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private ERole nome;

    public Role(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getNome() {
        return nome;
    }

    public void setNome(ERole nome) {
        this.nome = nome;
    }
}
