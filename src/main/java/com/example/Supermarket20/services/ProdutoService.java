package com.example.Supermarket20.services;


import com.example.Supermarket20.DTO.ProdutoDTO;
import com.example.Supermarket20.controller.exceptions.ResourceNotFoundException;
import com.example.Supermarket20.model.Categoria;
import com.example.Supermarket20.model.Produto;
import com.example.Supermarket20.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ProdutoService {
    private final ProdutoRepository pr;

    public ProdutoService(ProdutoRepository pr) {
        this.pr = pr;
    }

    public ProdutoDTO findById(UUID id){
        Produto p = pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("PRODUCT NOT FOUND"));
        return new ProdutoDTO(p.getName(),p.getValue());
    }

    public void save(String name, BigDecimal value, Categoria categoria,int quantity){
        if(value.compareTo(BigDecimal.ZERO) < 0) throw new ResourceNotFoundException("O PRECO NAO PODE SER NEGATIVO");
        Produto produtoDTO = new Produto();
        produtoDTO.setName(name);
        produtoDTO.setCategoria(categoria);
        produtoDTO.setValue(value);
        produtoDTO.setQuantity(quantity);
        pr.save(produtoDTO);
    }

    public void delete(UUID id){
        try {
            pr.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw  new ResourceNotFoundException("DATABASE ERROR");
        }
    }
}
