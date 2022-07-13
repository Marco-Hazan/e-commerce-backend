package com.aizoon.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.aizoon.project.dto.request.ProdottoRequestDto;
import com.aizoon.project.dto.response.ProdottoResponseDto;
import com.aizoon.project.service.ProdottoService;
		
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProdottoController {
	
	@Autowired
	private ProdottoService prodService;
	
	@PostMapping("/prodotti")
	public ResponseEntity<ProdottoResponseDto> save(@Valid @RequestBody ProdottoRequestDto prodotto) throws MethodArgumentNotValidException{
		ProdottoResponseDto response = prodService.create(prodotto);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/prodotti/{id}")
	public ResponseEntity<ProdottoResponseDto> update(
			@Valid @RequestBody ProdottoRequestDto prodotto, @PathVariable(value = "id") Long id )
	{
		return ResponseEntity.ok(prodService.update(prodotto, id));
	}
	
	@DeleteMapping("/prodotti/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id){
		Map<String, Boolean> message = new HashMap<>();
		prodService.delete(id);
		message.put("deleted", true);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/prodotti/{id}")
	public ResponseEntity<ProdottoResponseDto> getById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(prodService.findById(id));
	}
	

	@GetMapping("/prodotti")
	public ResponseEntity<List<ProdottoResponseDto>> getAll(){
		return  ResponseEntity.ok(prodService.findAll());
	}

	@GetMapping("/prodotti/categoria/")
	public ResponseEntity<Set<ProdottoResponseDto>> getByCategoria(@RequestParam Long[] categorie){
		return ResponseEntity.ok(prodService.getByCategoria(categorie));
	}

}
