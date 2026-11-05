package edu.altair.apicrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.apicrm.entities.Estado;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de Estado.
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}