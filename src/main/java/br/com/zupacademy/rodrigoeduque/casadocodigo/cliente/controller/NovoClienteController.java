package br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.controller;

import br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.controller.request.NovoClienteRequest;
import br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.model.Cliente;
import br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.repository.ClienteRepository;
import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.repository.EstadoRepository;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class NovoClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid NovoClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.toModel(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(cliente.getId());
    }
}
