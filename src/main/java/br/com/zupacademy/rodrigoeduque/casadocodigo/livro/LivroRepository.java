package br.com.zupacademy.rodrigoeduque.casadocodigo.livro;

import br.com.zupacademy.rodrigoeduque.casadocodigo.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
