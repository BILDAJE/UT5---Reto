
package edu.altair.apicrm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.apicrm.entities.Alumno;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de Alumno.
 */
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    /**
     * Busca un alumno por su DNI.
     * @param dni DNI del alumno
     * @return alumno encontrado, o Optional vacío si no existe
     */
    Optional<Alumno> findByDni(String dni);

    /**
     * Busca un alumno por su número de la Seguridad Social.
     * @param numeroSs número de la Seguridad Social
     * @return alumno encontrado, o Optional vacío si no existe
     */
    Optional<Alumno> findByNumeroSs(String numeroSs);

}
