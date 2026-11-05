package edu.altair.apicrm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.altair.apicrm.entities.Alumno;
import edu.altair.apicrm.repositories.AlumnoRepository;
import edu.altair.apicrm.services.AlumnoService;

/**
 * Implementación del servicio para gestionar la lógica de negocio de Alumno.
 */
@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    /**
     * Constructor del servicio de alumnos.
     * @param alumnoRepository repositorio de alumnos
     */
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    /**
     * Obtiene todos los alumnos.
     * @return lista de alumnos
     */
    @Override
    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    /**
     * Busca un alumno por su identificador.
     * @param id identificador del alumno
     * @return alumno encontrado
     * @throws IllegalArgumentException si no existe el alumno
     */
    @Override
    public Alumno buscarPorId(Long id) {
        if (alumnoRepository.existsById(id)) {
            return alumnoRepository.findById(id).get();
        }

        throw new IllegalArgumentException("No existe un alumno con el ID: " + id);
    }

    /**
     * Guarda un nuevo alumno.
     * @param alumno alumno que se desea guardar
     * @return alumno guardado
     */
    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    /**
     * Actualiza los datos de un alumno.
     *
     * @param id identificador del alumno
     * @param alumno nuevos datos del alumno
     * @return alumno actualizado
     */
    @Override
    public Alumno actualizarAlumno(Long id, Alumno alumno) {
        Alumno alumnoExistente = buscarPorId(id);

        alumnoExistente.setNombre(alumno.getNombre());
        alumnoExistente.setApellidos(alumno.getApellidos());
        alumnoExistente.setDni(alumno.getDni());
        alumnoExistente.setNumeroSs(alumno.getNumeroSs());
        alumnoExistente.setEmailPersonal(alumno.getEmailPersonal());
        alumnoExistente.setTelefonoPersonal(alumno.getTelefonoPersonal());
        alumnoExistente.setFechaAlta(alumno.getFechaAlta());
        alumnoExistente.setFechaBaja(alumno.getFechaBaja());
        alumnoExistente.setEmailCentro(alumno.getEmailCentro());
        alumnoExistente.setFamilia(alumno.getFamilia());

        return alumnoRepository.save(alumnoExistente);
    }

    /**
     * Elimina un alumno por su identificador.
     * @param id identificador del alumno
     */
    @Override
    public void eliminarAlumno(Long id) {
        Alumno alumno = buscarPorId(id);
        alumnoRepository.delete(alumno);
    }
}