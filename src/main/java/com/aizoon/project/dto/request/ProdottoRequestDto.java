package com.aizoon.project.dto.request;
import com.aizoon.project.model.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class ProdottoRequestDto {
	
	private Long id;
	
	@NotEmpty(message = "Il nome non può essere vuoto")
	private String nome;
	
	@NotBlank
	private String descrizione;
	
	@PositiveOrZero
	private Double prezzo;
	
	@PositiveOrZero
	private Double taglia;
	
	private String immagine;

	private Categoria categoria;

	public ProdottoRequestDto() {}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
