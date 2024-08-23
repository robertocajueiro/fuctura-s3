package com.biblioteca.fuctura.repositories;

import com.biblioteca.fuctura.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNome(String nome);

    Optional<Categoria> findByNomeContainingIgnoreCase(String nome);



//    @Query("SELECT c FROM Categoria c WHERE LOWER(c.nome) = LOWER(:nome)")
//    Optional<Categoria> findByNome(@Param("nome") String nome);
}
