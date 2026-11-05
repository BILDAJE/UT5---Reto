package edu.altair.apicrm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.apicrm.entities.Matricula;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de Matricula.
 */
@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    /**
     * Busca las matrículas de un alumno.
     * @param idAlumno identificador del alumno
     * @return lista de matrículas del alumno
     */
    List<Matricula> findByAlumno_IdAlumno(Long idAlumno);

    /**
     * Busca las matrículas de un módulo.
     * @param idModulo identificador del módulo
     * @return lista de matrículas del módulo
     */
    List<Matricula> findByModulo_IdModulo(Long idModulo);

    /**
     * Busca las matrículas asociadas a un estado.
     * @param idEstado identificador del estado
     * @return lista de matrículas del estado
     */
    List<Matricula> findByEstado_IdEstado(Long idEstado);
}