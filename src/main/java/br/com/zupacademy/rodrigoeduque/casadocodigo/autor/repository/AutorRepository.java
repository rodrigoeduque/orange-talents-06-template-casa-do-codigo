package br.com.zupacademy.rodrigoeduque.casadocodigo.autor.repository;

import br.com.zupacademy.rodrigoeduque.casadocodigo.autor.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
}
