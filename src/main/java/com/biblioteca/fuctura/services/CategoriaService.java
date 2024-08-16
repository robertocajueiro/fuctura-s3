package com.biblioteca.fuctura.services;

import com.biblioteca.fuctura.dtos.CategoriaDto;
import com.biblioteca.fuctura.models.Categoria;
import com.biblioteca.fuctura.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.get();
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(CategoriaDto categoriaDto) {
        categoriaDto.setId(null);
        return categoriaRepository.save(modelMapper.map(categoriaDto, Categoria.class));
    }

    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
