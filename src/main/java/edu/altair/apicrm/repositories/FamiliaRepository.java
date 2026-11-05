
package edu.altair.apicrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.apicrm.entities.Familia;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de Familia.
 */
@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

}
