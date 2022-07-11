package com.aizoon.project.service;

import com.aizoon.project.dto.response.CategoriaResponseDto;
import com.aizoon.project.model.Categoria;
import com.aizoon.project.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public CategoriaResponseDto findById(Long id){
        Categoria cat =  repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nessuna categoria trovata"));
        return cat.copyTo();
    }

    public List<CategoriaResponseDto> findAll(){
        return repo.findAll().stream()
                .map(categoria -> categoria.copyTo())
                .collect(Collectors.toList());
    }



}
