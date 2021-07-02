package br.com.zupacademy.rodrigoeduque.casadocodigo.estado.model;

import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;

import javax.persistence.*;

@Entity
@Table(name = "estados")
public class Estado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String nome;

  @ManyToOne(targetEntity = Pais.class)
  private Pais pais;

  @Deprecated
  public Estado() {}

  public Estado(String nome, Pais pais) {
    this.nome = nome;
    this.pais = pais;
  }
}
