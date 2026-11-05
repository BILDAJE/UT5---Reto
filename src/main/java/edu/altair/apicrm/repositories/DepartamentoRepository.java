
package edu.altair.apicrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.apicrm.entities.Departamento;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de Departamento.
 */
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
