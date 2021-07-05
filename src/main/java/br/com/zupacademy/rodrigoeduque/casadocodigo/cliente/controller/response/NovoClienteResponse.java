package br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.controller.response;

import br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.model.Cliente;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class NovoClienteResponse {

    @JsonDeserialize
    private Long id;

//    public NovoClienteResponse(Cliente cliente) {
//        this.id = cliente.getId();
//    }

    public Long getId() {
        return id;
    }
}
