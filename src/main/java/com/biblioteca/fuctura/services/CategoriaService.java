package com.biblioteca.fuctura.services;

import com.biblioteca.fuctura.models.Categoria;
import com.biblioteca.fuctura.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.get();
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}
