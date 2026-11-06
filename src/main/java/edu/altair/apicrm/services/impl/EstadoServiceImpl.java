package edu.altair.apicrm.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.altair.apicrm.entities.Estado;
import edu.altair.apicrm.exceptions.ResourceNotFoundException;
import edu.altair.apicrm.repositories.EstadoRepository;
import edu.altair.apicrm.services.EstadoService;

/**
 * Implementación del servicio para gestionar la lógica de negocio de Estado.
 */
@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository estadoRepository;

    /**
     * Constructor del servicio de estados.
     * @param estadoRepository repositorio de estados
     */
    public EstadoServiceImpl(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    /**
     * Obtiene todos los estados.
     * @return lista de estados
     */
    @Override
    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }

    /**
     * Busca un estado por su identificador.
     * @param id identificador del estado
     * @return estado encontrado
     * @throws ResourceNotFoundException si no existe el estado
     */
    @Override
    public Estado buscarPorId(Long id) {
        Optional<Estado> estado = estadoRepository.findById(id);

        if (estado.isPresent()) {
            return estado.get();
        }

        throw new ResourceNotFoundException("No existe un estado con el ID: " + id);
    }

    /**
     * Guarda un nuevo estado.
     * @param estado estado que se desea guardar
     * @return estado guardado
     */
    @Override
    public Estado guardarEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    /**
     * Actualiza los datos de un estado.
     * @param id identificador del estado
     * @param estado nuevos datos del estado
     * @return estado actualizado
     */
    @Override
    public Estado actualizarEstado(Long id, Estado estado) {
        Estado estadoExistente = buscarPorId(id);

        estadoExistente.setNombre(estado.getNombre());
        estadoExistente.setDescripcion(estado.getDescripcion());

        return estadoRepository.save(estadoExistente);
    }

    /**
     * Elimina un estado por su identificador.
     * @param id identificador del estado
     */
    @Override
    public void eliminarEstado(Long id) {
        Estado estado = buscarPorId(id);
        estadoRepository.delete(estado);
    }
}