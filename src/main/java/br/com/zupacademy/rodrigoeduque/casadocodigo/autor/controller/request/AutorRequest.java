package br.com.zupacademy.rodrigoeduque.casadocodigo.autor.controller.request;

import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.model.Autor;
import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.valorunico.ValorUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    @Email
    @ValorUnico(classe = Autor.class, atributo = "email", message = "Não foi possivel realizar o cadastro, pois este e-mail já existe em nossa base de dados")
    private String email;

    @NotBlank
    @NotNull
    @Size(max = 400)
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor convert() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getEmail() {
        return email;
    }
}
