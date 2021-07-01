package br.com.zupacademy.rodrigoeduque.casadocodigo.livro.detalheLivro.controller.response;

import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.model.Livro;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class DetalheLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private String isbn;
    private ResponseAutor autor;

    public DetalheLivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.autor = new ResponseAutor(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public ResponseAutor getAutor() {
        return autor;
    }
}
