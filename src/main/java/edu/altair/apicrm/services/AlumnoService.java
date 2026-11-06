package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.apicrm.entities.Alumno;

/**
 * Interfaz de servicio para gestionar la lógica de negocio de Alumno.
 */
public interface AlumnoService {

    /**
     * Obtiene todos los alumnos.
     * @return lista de alumnos	
     */
    List<Alumno> listarAlumnos();

    /**
     * Busca un alumno por su identificador.
     * @param id identificador del alumno
     * @return alumno encontrado
     */
    Alumno buscarPorId(Long id);

    /**
     * Guarda un nuevo alumno.
     * @param alumno alumno que se desea guardar
     * @return alumno guardado
     */
    Alumno guardarAlumno(Alumno alumno);

    /**
     * Actualiza los datos de un alumno.
     * @param id identificador del alumno
     * @param alumno nuevos datos del alumno
     * @return alumno actualizado
     */
    Alumno actualizarAlumno(Long id, Alumno alumno);

    /**
     * Elimina un alumno por su identificador.
     * @param id identificador del alumno
     */
    void eliminarAlumno(Long id);
}