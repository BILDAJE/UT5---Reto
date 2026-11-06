package edu.altair.apicrm.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.altair.apicrm.entities.Curso;
import edu.altair.apicrm.exceptions.ResourceNotFoundException;
import edu.altair.apicrm.repositories.CursoRepository;
import edu.altair.apicrm.services.CursoService;

/**
 * Implementación del servicio para gestionar la lógica de negocio de Curso.
 */
@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    /**
     * Constructor del servicio de cursos.
     * @param cursoRepository repositorio de cursos
     */
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    /**
     * Obtiene todos los cursos.
     * @return lista de cursos
     */
    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    /**
     * Busca un curso por su identificador.
     * @param id identificador del curso
     * @return curso encontrado
     * @throws ResourceNotFoundException si no existe el curso
     */
    @Override
    public Curso buscarPorId(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);

        if (curso.isPresent()) {
            return curso.get();
        }

        throw new ResourceNotFoundException("No existe un curso con el ID: " + id);
    }

    /**
     * Guarda un nuevo curso.
     * @param curso curso que se desea guardar
     * @return curso guardado
     */
    @Override
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    /**
     * Actualiza los datos de un curso.
     * @param id identificador del curso
     * @param curso nuevos datos del curso
     * @return curso actualizado
     */
    @Override
    public Curso actualizarCurso(Long id, Curso curso) {
        Curso cursoExistente = buscarPorId(id);

        cursoExistente.setDiminutivo(curso.getDiminutivo());
        cursoExistente.setDescripcion(curso.getDescripcion());
        cursoExistente.setTitulacion(curso.getTitulacion());
        cursoExistente.setModulos(curso.getModulos());

        return cursoRepository.save(cursoExistente);
    }

    /**
     * Elimina un curso por su identificador.
     * @param id identificador del curso
     */
    @Override
    public void eliminarCurso(Long id) {
        Curso curso = buscarPorId(id);
        cursoRepository.delete(curso);
    }
}