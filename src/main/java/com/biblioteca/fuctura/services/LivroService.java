package com.biblioteca.fuctura.services;

import com.biblioteca.fuctura.dtos.LivroDto;
import com.biblioteca.fuctura.exceptions.ObjectNotFoundException;
import com.biblioteca.fuctura.models.Categoria;
import com.biblioteca.fuctura.models.Livro;
import com.biblioteca.fuctura.repositories.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> cat = livroRepository.findById(id);
        if (cat.isPresent()) {
            return cat.get();
        }
        throw new ObjectNotFoundException("Livro não encontrada!");
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllLivrosByCategoria(id_cat);
    }

    public List<Livro> findAllByCategoriaNome(String nome) {
        categoriaService.buscarPorNome(nome);
        return livroRepository.findByCategoriaNomeContainingIgnoreCase(nome);
    }

    public Livro save(Integer id_cat, LivroDto livroDto) {
        livroDto.setId(null);
        Categoria cat = categoriaService.findById(id_cat);
        livroDto.setCategoria(cat);
        return livroRepository.save(new Livro(livroDto));
    }

    public Livro update(Integer id, LivroDto livroDto) {
        Livro livro = findById(id);
        livroDto.setId(livro.getId());
        return livroRepository.save(new Livro(livroDto));
    }

    public void delete(Integer id) {
        findById(id);
        livroRepository.deleteById(id);
    }

}
