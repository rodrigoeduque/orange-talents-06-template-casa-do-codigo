package br.com.zupacademy.rodrigoeduque.casadocodigo.controller.dto;

import br.com.zupacademy.rodrigoeduque.casadocodigo.model.Autor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


public class AutorDto {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataRegistro;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataRegistro = autor.getDataRegistro();
    }
}
