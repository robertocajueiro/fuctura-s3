package com.biblioteca.fuctura.controllers;

import com.biblioteca.fuctura.models.Categoria;
import com.biblioteca.fuctura.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return cat;
    }

    @GetMapping
    public List<Categoria> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return list;
    }

}
