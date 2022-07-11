package com.aizoon.project.model;

import com.aizoon.project.dto.request.CategoriaRequestDto;
import com.aizoon.project.dto.response.CategoriaResponseDto;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "categorie")
public class Categoria implements IEntity<CategoriaRequestDto, CategoriaResponseDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Prodotto> prodotti;

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    public Categoria(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public CategoriaResponseDto copyTo() {
        CategoriaResponseDto cat = new CategoriaResponseDto();
        BeanUtils.copyProperties(this,cat);
        if(this.prodotti != null) {
            cat.setProdotti(
                    this.prodotti.stream()
                            .map(p -> p.copyTo())
                            .collect(Collectors.toList())
            );
            cat.setTotItems(this.prodotti.size());
        }

        return cat;
    }

    @Override
    public void copyFrom(CategoriaRequestDto req) {
        this.setNome(req.getNome());
    }
}
