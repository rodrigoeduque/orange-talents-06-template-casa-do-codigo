package br.com.zupacademy.rodrigoeduque.casadocodigo.pais.controller;

import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.controller.request.NovoPaisRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;
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
public class PaisController {

  private static Logger LOGGER = LoggerFactory.getLogger(PaisController.class);

  private PaisRepository paisRepository;

  @Autowired
  public PaisController(PaisRepository paisRepository) {
    this.paisRepository = paisRepository;
  }


  @PostMapping("/paises")
  public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoPaisRequest novoPaisRequest) {

    LOGGER.info("Request: " + novoPaisRequest);

    Pais pais = novoPaisRequest.toModel();
    paisRepository.save(pais);

    return ResponseEntity.ok().build();
  }
}
