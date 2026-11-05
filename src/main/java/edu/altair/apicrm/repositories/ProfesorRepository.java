
package edu.altair.apicrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.apicrm.entities.Profesor;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de Profesor.
 */
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
