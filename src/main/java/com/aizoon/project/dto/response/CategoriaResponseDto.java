package com.aizoon.project.dto.response;

import com.aizoon.project.model.Categoria;
import com.aizoon.project.model.Prodotto;

import java.util.List;

public class CategoriaResponseDto {

    private Long id;
    private String nome;

    private List<ProdottoResponseDto> prodotti;

    private int totItems;

    public CategoriaResponseDto(){}

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

    public List<ProdottoResponseDto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<ProdottoResponseDto> prodotti) {
        this.prodotti = prodotti;
    }

    public int getTotItems() {
        return totItems;
    }

    public void setTotItems(int totItems) {
        this.totItems = totItems;
    }
}
