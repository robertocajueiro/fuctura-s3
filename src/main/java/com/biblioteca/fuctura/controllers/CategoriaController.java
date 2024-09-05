package com.biblioteca.fuctura.controllers;

import com.biblioteca.fuctura.dtos.CategoriaDto;
import com.biblioteca.fuctura.models.Categoria;
import com.biblioteca.fuctura.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        CategoriaDto catDto = modelMapper.map(cat, CategoriaDto.class);
        return ResponseEntity.ok().body(catDto);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, CategoriaDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> save(@Valid @RequestBody CategoriaDto categoriaDto) {
        Categoria cat = categoriaService.save(categoriaDto);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Integer id, @Valid @RequestBody CategoriaDto categoriaDto) {
        categoriaDto.setId(id);
        Categoria cat = categoriaService.update(categoriaDto);
        CategoriaDto catDto = modelMapper.map(cat, CategoriaDto.class);
        return ResponseEntity.ok().body(catDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        categoriaService.delete(id);
       return ResponseEntity.noContent().build();
    }
}
