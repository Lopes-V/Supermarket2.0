package com.example.Supermarket20.controller;


import com.example.Supermarket20.DTO.ProdutoDTO;
import com.example.Supermarket20.model.Produto;
import com.example.Supermarket20.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/produtos")
public class ControllerProduto {

    private final ProdutoService service;

    public ControllerProduto(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findProductById(@PathVariable UUID id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public void saveProduct(@RequestBody Produto p){
        service.save(p.getName(),p.getValue(),p.getCategoria(),p.getQuantity());
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id){
        service.delete(id);
    }
}
