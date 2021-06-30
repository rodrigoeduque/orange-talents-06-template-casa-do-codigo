package br.com.zupacademy.rodrigoeduque.casadocodigo.livro.controller.request;

import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.model.Autor;
import br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.model.Categoria;
import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.valorunico.ValorUnico;
import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.verificacaoid.VerificaId;
import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @ValorUnico(message = "Este titulo já existe em nossa base de dados",classe = Livro.class,atributo = "titulo")
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer paginas;
    @NotBlank
    @ValorUnico(message = "Código ISBN já existe em nossa base de dados",classe = Livro.class,atributo = "isbn")
    private String isbn;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) @Future
    private LocalDate dataPublicacao;
    @NotNull
    @VerificaId(message = "Código categoria inválida/inexistente", atributo = "id",classe = Categoria.class)
    private Long id_categoria;
    @NotNull
    @VerificaId(message = "Código autor inválido/inexistente", atributo = "id", classe = Autor.class)
    private Long id_autor;

    public LivroRequest( String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn, Long id_categoria, Long id_autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.id_categoria = id_categoria;
        this.id_autor = id_autor;
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public Long getId_autor() {
        return id_autor;
    }

    @Override
    public String toString() {
        return "LivroRequest{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", paginas=" + paginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", id_categoria=" + id_categoria +
                ", id_autor=" + id_autor +
                '}';
    }

    public Livro toModel(EntityManager em) {
        @NotNull
        Categoria categoria = em.find(Categoria.class, id_categoria);
        @NotNull
        Autor autor = em.find(Autor.class,id_autor);
        return new Livro(titulo,resumo,sumario,preco,paginas,isbn,dataPublicacao,categoria,autor);
    }
}
