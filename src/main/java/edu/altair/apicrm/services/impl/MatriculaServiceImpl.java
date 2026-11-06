package edu.altair.apicrm.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.altair.apicrm.entities.Matricula;
import edu.altair.apicrm.exceptions.ResourceNotFoundException;
import edu.altair.apicrm.repositories.MatriculaRepository;
import edu.altair.apicrm.services.MatriculaService;

/**
 * Implementación del servicio para gestionar la lógica de negocio de Matricula.
 */
@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;

    /**
     * Constructor del servicio de matrículas.
     * @param matriculaRepository repositorio de matrículas
     */
    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    /**
     * Obtiene todas las matrículas.
     * @return lista de matrículas
     */
    @Override
    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    /**
     * Busca una matrícula por su identificador.
     * @param id identificador de la matrícula
     * @return matrícula encontrada
     * @throws ResourceNotFoundException si no existe la matrícula
     */
    @Override
    public Matricula buscarPorId(Long id) {
        Optional<Matricula> matricula = matriculaRepository.findById(id);

        if (matricula.isPresent()) {
            return matricula.get();
        }

        throw new ResourceNotFoundException("No existe una matrícula con el ID: " + id);
    }

    /**
     * Busca las matrículas de un alumno.
     * @param idAlumno identificador del alumno
     * @return lista de matrículas del alumno
     */
    @Override
    public List<Matricula> buscarPorAlumno(Long idAlumno) {
        return matriculaRepository.findByAlumno_IdAlumno(idAlumno);
    }

    /**
     * Guarda una nueva matrícula.
     * @param matricula matrícula que se desea guardar
     * @return matrícula guardada
     */
    @Override
    public Matricula guardarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    /**
     * Actualiza los datos de una matrícula.
     * @param id identificador de la matrícula
     * @param matricula nuevos datos de la matrícula
     * @return matrícula actualizada
     */
    @Override
    public Matricula actualizarMatricula(Long id, Matricula matricula) {
        Matricula matriculaExistente = buscarPorId(id);

        matriculaExistente.setAlumno(matricula.getAlumno());
        matriculaExistente.setModulo(matricula.getModulo());
        matriculaExistente.setEstado(matricula.getEstado());

        return matriculaRepository.save(matriculaExistente);
    }

    /**
     * Elimina una matrícula por su identificador.
     * @param id identificador de la matrícula
     */
    @Override
    public void eliminarMatricula(Long id) {
        Matricula matricula = buscarPorId(id);
        matriculaRepository.delete(matricula);
    }
}