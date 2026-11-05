package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.apicrm.entities.Matricula;

/**
 * Interfaz de servicio para gestionar la lógica de negocio de Matricula.
 */
public interface MatriculaService {

    /**
     * Obtiene todas las matrículas.
     * @return lista de matrículas
     */
    List<Matricula> listarMatriculas();

    /**
     * Busca una matrícula por su identificador.
     * @param id identificador de la matrícula
     * @return matrícula encontrada
     */
    Matricula buscarPorId(Long id);

    /**
     * Busca las matrículas de un alumno.
     * @param idAlumno identificador del alumno
     * @return lista de matrículas del alumno
     */
    List<Matricula> buscarPorAlumno(Long idAlumno);

    /**
     * Guarda una nueva matrícula.
     * @param matricula matrícula que se desea guardar
     * @return matrícula guardada
     */
    Matricula guardarMatricula(Matricula matricula);

    /**
     * Actualiza los datos de una matrícula.
     * @param id identificador de la matrícula
     * @param matricula nuevos datos de la matrícula
     * @return matrícula actualizada
     */
    Matricula actualizarMatricula(Long id, Matricula matricula);

    /**
     * Elimina una matrícula por su identificador.
     * @param id identificador de la matrícula
     */
    void eliminarMatricula(Long id);
}