package br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model;

import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.model.Estado;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "pais",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estado> estados = new ArrayList<>();

    @Deprecated
    public Pais() {
    }

    public Pais(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pais(String nome) {

        this.nome = nome;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
