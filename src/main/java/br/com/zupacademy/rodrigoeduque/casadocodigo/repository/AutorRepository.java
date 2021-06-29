package br.com.zupacademy.rodrigoeduque.casadocodigo.repository;

import br.com.zupacademy.rodrigoeduque.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
