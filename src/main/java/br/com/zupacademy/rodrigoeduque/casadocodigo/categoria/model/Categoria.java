package br.com.zupacademy.rodrigoeduque.casadocodigo.categoria.model;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria(String nome) {

        this.nome = nome;
    }

}
