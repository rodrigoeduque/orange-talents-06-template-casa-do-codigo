package br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model;

import javax.persistence.*;

@Entity
@Table(name = "paises")
public class Pais {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String nome;

  @Deprecated
  public Pais() {}

  public Pais(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Pais(String nome) {
    this.nome = nome;
  }
}
