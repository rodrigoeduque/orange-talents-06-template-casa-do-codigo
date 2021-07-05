package br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.repository;

import br.com.zupacademy.rodrigoeduque.casadocodigo.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
