package com.aizoon.project.controller;

import com.aizoon.project.dto.response.CategoriaResponseDto;
import com.aizoon.project.model.Categoria;
import com.aizoon.project.service.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class CategoriaController {

    @Autowired
    private CategoriaService catService;

    @GetMapping("/categorie/{id}")
    public ResponseEntity<CategoriaResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(catService.findById(id));
    }

    @GetMapping("/categorie")
    public ResponseEntity<List<CategoriaResponseDto>> findAll(){
        return ResponseEntity.ok(catService.findAll());
    }

}
