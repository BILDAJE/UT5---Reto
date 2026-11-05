package edu.altair.apicrm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.apicrm.entities.Curso;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de Curso.
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    /**
     * Busca un curso por su diminutivo.
     * @param diminutivo diminutivo del curso
     * @return curso encontrado, o Optional vacío si no existe
     */
    Optional<Curso> findByDiminutivo(String diminutivo);

    /**
     * Comprueba si existe un curso con el diminutivo indicado.
     * @param diminutivo diminutivo del curso
     * @return true si existe, false en caso contrario
     */
    boolean existsByDiminutivo(String diminutivo);
}