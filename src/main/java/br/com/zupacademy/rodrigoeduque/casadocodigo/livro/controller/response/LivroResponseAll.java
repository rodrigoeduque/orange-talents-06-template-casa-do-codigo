package br.com.zupacademy.rodrigoeduque.casadocodigo.livro.controller.response;

import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponseAll {

    private Long id;
    private String nomeLivro;

    public LivroResponseAll(Livro livro) {
        this.id = livro.getId();
        this.nomeLivro = livro.getTitulo();
    }

    public static List<LivroResponseAll> convert(List<Livro> livros) {
        return livros.stream().map(LivroResponseAll::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }


}
