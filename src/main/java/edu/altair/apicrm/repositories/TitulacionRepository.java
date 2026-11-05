package edu.altair.apicrm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.apicrm.entities.Titulacion;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de Titulacion.
 */
@Repository
public interface TitulacionRepository extends JpaRepository<Titulacion, Long> {

    /**
     * Busca una titulación por su código.
     * @param codigo código de la titulación
     * @return titulación encontrada, o Optional vacío si no existe
     */
    Optional<Titulacion> findByCodigo(String codigo);

    /**
     * Comprueba si existe una titulación con el código indicado.
     * @param codigo código de la titulación
     * @return true si existe, false en caso contrario
     */
    boolean existsByCodigo(String codigo);

    /**
     * Busca una titulación por su diminutivo.
     * @param diminutivo diminutivo de la titulación
     * @return titulación encontrada, o Optional vacío si no existe
     */
    Optional<Titulacion> findByDiminutivo(String diminutivo);

    /**
     * Comprueba si existe una titulación con el diminutivo indicado.
     * @param diminutivo diminutivo de la titulación
     * @return true si existe, false en caso contrario
     */
    boolean existsByDiminutivo(String diminutivo);
}