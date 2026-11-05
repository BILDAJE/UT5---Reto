package edu.altair.apicrm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.altair.apicrm.entities.Profesor;
import edu.altair.apicrm.repositories.ProfesorRepository;
import edu.altair.apicrm.services.ProfesorService;

/**
 * Implementación del servicio para gestionar la lógica de negocio de Profesor.
 */
@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    /**
     * Constructor del servicio de profesores.
     * @param profesorRepository repositorio de profesores
     */
    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    /**
     * Obtiene todos los profesores.
     * @return lista de profesores
     */
    @Override
    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    /**
     * Busca un profesor por su identificador.
     * @param id identificador del profesor
     * @return profesor encontrado
     * @throws IllegalArgumentException si no existe el profesor
     */
    @Override
    public Profesor buscarPorId(Long id) {
        if (profesorRepository.existsById(id)) {
            return profesorRepository.findById(id).get();
        }

        throw new IllegalArgumentException("No existe un profesor con el ID: " + id);
    }

    /**
     * Guarda un nuevo profesor.
     * @param profesor profesor que se desea guardar
     * @return profesor guardado
     */
    @Override
    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    /**
     * Actualiza los datos de un profesor.
     * @param id identificador del profesor
     * @param profesor nuevos datos del profesor
     * @return profesor actualizado
     */
    @Override
    public Profesor actualizarProfesor(Long id, Profesor profesor) {
        Profesor profesorExistente = buscarPorId(id);

        profesorExistente.setNombre(profesor.getNombre());
        profesorExistente.setDepartamento(profesor.getDepartamento());

        return profesorRepository.save(profesorExistente);
    }

    /**
     * Elimina un profesor por su identificador.
     * @param id identificador del profesor
     */
    @Override
    public void eliminarProfesor(Long id) {
        Profesor profesor = buscarPorId(id);
        profesorRepository.delete(profesor);
    }
}