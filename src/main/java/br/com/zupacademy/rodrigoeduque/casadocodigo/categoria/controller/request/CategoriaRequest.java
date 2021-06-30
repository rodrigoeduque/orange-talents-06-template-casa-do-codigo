package br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.controller.request;

import br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.model.Categoria;
import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.valorunico.ValorUnico;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaRequest {

    @NotNull
    @NotBlank
    @ValorUnico(classe = Categoria.class,atributo = "nome", message = "Este nome de categoria já existe!" )
    private String nome;

    public String getNome() {
        return nome;
    }

    @Deprecated
    public CategoriaRequest() {
    }

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {

        return new Categoria(this.nome);
    }
}
