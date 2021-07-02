package br.com.zupacademy.rodrigoeduque.casadocodigo.estado.controller;

import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.controller.request.NovoEstadoRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.model.Estado;
import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.repository.EstadoRepository;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.repository.PaisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EstadoController {

  private static Logger LOGGER = LoggerFactory.getLogger(EstadoController.class);

  private EstadoRepository estadoRepository;
  private PaisRepository paisRepository;

  @Autowired
  public EstadoController(EstadoRepository estadoRepository,PaisRepository paisRepository) {
    this.estadoRepository = estadoRepository;
    this.paisRepository = paisRepository;
  }

  @PostMapping("/estados")
  public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) {
    LOGGER.info("request: " + novoEstadoRequest.toString());
    Estado recebeEstado = novoEstadoRequest.toModel(paisRepository);
    estadoRepository.save(recebeEstado);
    LOGGER.info("no banco: " + recebeEstado);
    return ResponseEntity.ok().build();
  }
}
