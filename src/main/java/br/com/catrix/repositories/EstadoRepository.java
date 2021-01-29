package br.com.catrix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.catrix.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
