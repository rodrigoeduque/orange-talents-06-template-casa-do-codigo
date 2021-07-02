package br.com.zupacademy.rodrigoeduque.casadocodigo.estado.controller.request;

import br.com.zupacademy.rodrigoeduque.casadocodigo.config.validacao.anotationValidator.verificacaoid.VerificaId;
import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.model.Estado;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.repository.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class NovoEstadoRequest {

  @NotBlank private String nome;

  @VerificaId(classe = Pais.class, atributo = "id", message = "Código do país inválido")
  private Long id_pais;

  @Deprecated
  public NovoEstadoRequest() {}

  public NovoEstadoRequest(String nome, Long id_pais) {
    this.nome = nome;
    this.id_pais = id_pais;
  }

  public String getNome() {
    return nome;
  }

  public Long getId_pais() {
    return id_pais;
  }

  @Override
  public String toString() {
    return "NovoEstadoRequest{" + "nome='" + nome + '\'' + ", id_pais=" + id_pais + '}';
  }

  public Estado toModel(PaisRepository paisRepository) {

    Optional<Pais> pais = paisRepository.findById(id_pais);

    if (pais.isPresent()) {
      System.out.println(pais);
      return new Estado(nome, pais.get());
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "País Não encontrado");
  }
}
