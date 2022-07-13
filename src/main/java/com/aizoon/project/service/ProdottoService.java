package com.aizoon.project.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.aizoon.project.model.Categoria;
import com.aizoon.project.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.aizoon.project.dto.request.ProdottoRequestDto;
import com.aizoon.project.dto.response.ProdottoResponseDto;
import com.aizoon.project.model.Prodotto;
import com.aizoon.project.repository.ProdottoRepository;

@Service
public class ProdottoService {

	@Autowired
	private ProdottoRepository repo;

	@Autowired
	private CategoriaRepository catRepo;
	
	public ProdottoResponseDto create(ProdottoRequestDto prodotto) {
		Prodotto prod = new Prodotto();
		prod.copyFrom(prodotto);
		return repo.save(prod).copyTo();
	}
	
	
	public ProdottoResponseDto update(ProdottoRequestDto prodotto, Long id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
		prodotto.setId(id);
		Prodotto prod = new Prodotto();
		prod.copyFrom(prodotto);
		return repo.save(prod).copyTo();
	}
	
	public void delete(Long id) {
		Prodotto prod = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
		repo.delete(prod);
	}
	
	public ProdottoResponseDto findById(Long id) {
		Prodotto prod = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
		return prod.copyTo();
	}
	
	public List<ProdottoResponseDto> findAll(){
		List<Prodotto> prodotti = repo.findAll();
		return prodotti.stream()
				.map(prod -> prod.copyTo())
				.collect(Collectors.toList());
	}

	public Set<ProdottoResponseDto> getByCategoria(Long[] categorie){
		Set<ProdottoResponseDto> prodotti = new HashSet<>();
		for(Long id: categorie) {
			Categoria cat = catRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nessuna categoria trovata"));
			Set<ProdottoResponseDto> partial = cat.getProdotti().stream()
					.map(p -> p.copyTo())
					.collect(Collectors.toSet());
			prodotti.addAll(partial);
		}
		return prodotti;
	}
}
