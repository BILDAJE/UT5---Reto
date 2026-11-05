package edu.altair.apicrm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.apicrm.entities.Modulo;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de Modulo.
 */
@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {

    /**
     * Busca un módulo por su código.
     * @param codigo código del módulo
     * @return módulo encontrado, o Optional vacío si no existe
     */
    Optional<Modulo> findByCodigo(String codigo);

    /**
     * Comprueba si existe un módulo con el código indicado.
     * @param codigo código del módulo
     * @return true si existe, false en caso contrario
     */
    boolean existsByCodigo(String codigo);
}