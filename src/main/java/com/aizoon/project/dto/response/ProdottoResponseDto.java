package com.aizoon.project.dto.response;

import com.aizoon.project.model.Categoria;

public class ProdottoResponseDto {
	
	private Long id;
	
	private String nome;
	
	private String descrizione;
	
	private Double prezzo;
	
	private Double taglia;
	
	private String immagine;

	private CategoriaResponseDto categoria;



	public ProdottoResponseDto() {}

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Double getTaglia() {
		return taglia;
	}

	public void setTaglia(Double taglia) {
		this.taglia = taglia;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public CategoriaResponseDto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaResponseDto categoria) {
		this.categoria = categoria;
	}
}
