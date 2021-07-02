package br.com.zupacademy.rodrigoeduque.casadocodigo.pais.controller.request;

import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

  @NotBlank private String nome;

  @Deprecated
  public NovoPaisRequest() {}

  public NovoPaisRequest(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public Pais toModel() {
    return new Pais(this.nome);
  }
}
