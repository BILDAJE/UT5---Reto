package edu.altair.apicrm.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.altair.apicrm.entities.Departamento;
import edu.altair.apicrm.exceptions.ResourceNotFoundException;
import edu.altair.apicrm.repositories.DepartamentoRepository;
import edu.altair.apicrm.services.DepartamentoService;

/**
 * Implementación del servicio para gestionar la lógica de negocio de Departamento.
 */
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    /**
     * Constructor del servicio de departamentos.
     * @param departamentoRepository repositorio de departamentos
     */
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    /**
     * Obtiene todos los departamentos.
     * @return lista de departamentos
     */
    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    /**
     * Busca un departamento por su identificador.
     * @param id identificador del departamento
     * @return departamento encontrado
     * @throws ResourceNotFoundException si no existe el departamento
     */
    @Override
    public Departamento buscarPorId(Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);

        if (departamento.isPresent()) {
            return departamento.get();
        }

        throw new ResourceNotFoundException("No existe un departamento con el ID: " + id);
    }

    /**
     * Guarda un nuevo departamento.
     * @param departamento departamento que se desea guardar
     * @return departamento guardado
     */
    @Override
    public Departamento guardarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    /**
     * Actualiza los datos de un departamento.
     * @param id identificador del departamento
     * @param departamento nuevos datos del departamento
     * @return departamento actualizado
     */
    @Override
    public Departamento actualizarDepartamento(Long id, Departamento departamento) {
        Departamento departamentoExistente = buscarPorId(id);

        departamentoExistente.setCodigo(departamento.getCodigo());
        departamentoExistente.setNombre(departamento.getNombre());
        departamentoExistente.setDescripcion(departamento.getDescripcion());
        departamentoExistente.setTelefono(departamento.getTelefono());

        return departamentoRepository.save(departamentoExistente);
    }

    /**
     * Elimina un departamento por su identificador.
     * @param id identificador del departamento
     */
    @Override
    public void eliminarDepartamento(Long id) {
        Departamento departamento = buscarPorId(id);
        departamentoRepository.delete(departamento);
    }
}