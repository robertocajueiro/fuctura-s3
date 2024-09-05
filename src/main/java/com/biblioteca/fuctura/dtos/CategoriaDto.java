package com.biblioteca.fuctura.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoriaDto {

    private Integer id;

    @NotEmpty(message = "O campo nome é necessário")
    @Length(min = 3, max = 20, message = "O campo nome deve conter entre 3 e 20 caracteres")
    private String nome;

    @NotEmpty(message = "O campo nome é necessário")
    @Length(min = 20, max = 50, message = "O campo nome deve conter entre 20 e 50 caracteres")

    private String descricao;

    public CategoriaDto() {}

    public CategoriaDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
