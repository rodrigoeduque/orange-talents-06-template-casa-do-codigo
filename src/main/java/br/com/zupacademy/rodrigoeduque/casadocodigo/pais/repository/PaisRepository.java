package br.com.zupacademy.rodrigoeduque.casadocodigo.pais.repository;

import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {}
