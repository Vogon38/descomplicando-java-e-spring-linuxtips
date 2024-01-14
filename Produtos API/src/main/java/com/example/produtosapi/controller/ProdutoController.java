package com.example.produtosapi.controller;

import com.example.produtosapi.model.Produto;
import com.example.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/produtos")
    public Produto save(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/produtos/{id}")
    public Produto findById(@PathVariable("id") String produtoId) {
        return produtoRepository.findById(produtoId);
    }

    @GetMapping("/produtos/all")
    public Produto[] findAll() {
        return produtoRepository.findAll();
    }

    @DeleteMapping("/produtos/{id}")
    public String deleteById(@PathVariable("id") String produtoId) {
        return produtoRepository.deleteById(produtoId);
    }

    @PutMapping("/produtos/{id}")
    public Produto update(@PathVariable("id") String produtoId, @RequestBody Produto produto) {
        return produtoRepository.update(produtoId, produto);
    }

}
