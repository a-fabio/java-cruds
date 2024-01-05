package com.pocs.padrao.controller;

import com.pocs.padrao.entity.Categoria;
import com.pocs.padrao.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/cadastrar")
    ResponseEntity<?> cadastrar (@RequestBody Categoria categoria) {
            categoriaRepository.save(categoria);
            return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }

    @GetMapping
    List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @PutMapping
    ResponseEntity<?> modificar (@RequestBody Categoria categoria) {
        return new ResponseEntity<>(categoriaRepository.save(categoria), HttpStatus.OK);
    }

    @DeleteMapping("{$id}")
    ResponseEntity deletar(@PathVariable Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
