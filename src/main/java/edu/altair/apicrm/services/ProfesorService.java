package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.apicrm.entities.Profesor;

/**
 * Interfaz de servicio para gestionar la lógica de negocio de Profesor.
 */
public interface ProfesorService {

    /**
     * Obtiene todos los profesores.
     * @return lista de profesores
     */
    List<Profesor> listarProfesores();

    /**
     * Busca un profesor por su identificador.
     * @param id identificador del profesor
     * @return profesor encontrado
     */
    Profesor buscarPorId(Long id);

    /**
     * Guarda un nuevo profesor.
     * @param profesor profesor que se desea guardar
     * @return profesor guardado
     */
    Profesor guardarProfesor(Profesor profesor);

    /**
     * Actualiza los datos de un profesor.
     * @param id identificador del profesor
     * @param profesor nuevos datos del profesor
     * @return profesor actualizado
     */
    Profesor actualizarProfesor(Long id, Profesor profesor);

    /**
     * Elimina un profesor por su identificador.
     * @param id identificador del profesor
     */
    void eliminarProfesor(Long id);
}