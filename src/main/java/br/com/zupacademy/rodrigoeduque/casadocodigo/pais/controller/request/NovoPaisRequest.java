package br.com.zupacademy.rodrigoeduque.casadocodigo.pais.controller.request;

import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.valorunico.ValorUnico;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

  @NotBlank
  @ValorUnico(classe = Pais.class,atributo = "nome", message = "Nome já cadastrado")
  private String nome;

  @Deprecated
  public NovoPaisRequest() {}

  public NovoPaisRequest(Pais pais) {
    this.nome = pais.getNome();
  }

  public String getNome() {
    return nome;
  }

  public Pais toModel() {
    return new Pais(this.getNome());
  }
}
