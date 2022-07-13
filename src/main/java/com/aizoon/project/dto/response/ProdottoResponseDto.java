package com.aizoon.project.dto.response;

import com.aizoon.project.model.Categoria;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProdottoResponseDto that = (ProdottoResponseDto) o;
		return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(descrizione, that.descrizione) && Objects.equals(prezzo, that.prezzo) && Objects.equals(taglia, that.taglia) && Objects.equals(immagine, that.immagine) && Objects.equals(categoria, that.categoria);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, descrizione, prezzo, taglia, immagine, categoria);
	}
}
