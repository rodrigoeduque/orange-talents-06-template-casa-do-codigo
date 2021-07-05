package br.com.zupacademy.rodrigoeduque.casadocodigo.estado.repository;

import br.com.zupacademy.rodrigoeduque.casadocodigo.estado.model.Estado;
import br.com.zupacademy.rodrigoeduque.casadocodigo.pais.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    int countByNomeAndPais(String nome, Pais pais);

    int countByPais_Id(Long id);

}
