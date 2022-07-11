package com.aizoon.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.aizoon.project.dto.response.CategoriaResponseDto;
import org.springframework.beans.BeanUtils;

import com.aizoon.project.dto.request.ProdottoRequestDto;
import com.aizoon.project.dto.response.ProdottoResponseDto;

@Entity
@Table(name = "t_prodotti")
public class Prodotto implements IEntity<ProdottoRequestDto, ProdottoResponseDto>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "Il nome non può essere vuoto")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	
	@Column(name = "prezzo", nullable = false)
	private Double prezzo;
	
	@Column(name = "taglia")
	private Double taglia;
	
	@Column(name = "immagine")
	private String immagine;

	@ManyToOne
	@JoinColumn(name = "categoria")
	private Categoria categoria;


	public Prodotto() {}

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

	@Override
	public ProdottoResponseDto copyTo() {
		ProdottoResponseDto dto = new ProdottoResponseDto();
		BeanUtils.copyProperties(this, dto);
		Categoria cat = new Categoria();
		cat.setId(this.getCategoria().getId());
		cat.setNome(this.getCategoria().getNome());
		dto.setCategoria(cat.copyTo());
		return dto;
	}

	@Override
	public void copyFrom(ProdottoRequestDto req) {
		BeanUtils.copyProperties(req, this);
	}
	
	
	
	
}
