package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.apicrm.entities.Curso;

/**
 * Interfaz de servicio para gestionar la lógica de negocio de Curso.
 */
public interface CursoService {

    /**
     * Obtiene todos los cursos.
     * @return lista de cursos
     */
    List<Curso> listarCursos();

    /**
     * Busca un curso por su identificador.
     * @param id identificador del curso
     * @return curso encontrado
     */
    Curso buscarPorId(Long id);

    /**
     * Guarda un nuevo curso.
     * @param curso curso que se desea guardar
     * @return curso guardado
     */
    Curso guardarCurso(Curso curso);

    /**
     * Actualiza los datos de un curso.
     * @param id identificador del curso
     * @param curso nuevos datos del curso
     * @return curso actualizado
     */
    Curso actualizarCurso(Long id, Curso curso);

    /**
     * Elimina un curso por su identificador.
     * @param id identificador del curso
     */
    void eliminarCurso(Long id);
}