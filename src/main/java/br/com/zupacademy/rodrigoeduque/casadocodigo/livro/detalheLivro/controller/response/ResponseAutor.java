package br.com.zupacademy.rodrigoeduque.casadocodigo.livro.detalheLivro.controller.response;

import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.model.Autor;

public class ResponseAutor {

    private String nome;
    private String descricao;

    public ResponseAutor(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
