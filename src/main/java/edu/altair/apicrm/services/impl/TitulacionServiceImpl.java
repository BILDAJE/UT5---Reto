package edu.altair.apicrm.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.altair.apicrm.entities.Titulacion;
import edu.altair.apicrm.exceptions.ResourceNotFoundException;
import edu.altair.apicrm.repositories.TitulacionRepository;
import edu.altair.apicrm.services.TitulacionService;

/**
 * Implementación del servicio para gestionar la lógica de negocio de Titulacion.
 */
@Service
public class TitulacionServiceImpl implements TitulacionService {

    private final TitulacionRepository titulacionRepository;

    /**
     * Constructor del servicio de titulaciones.
     * @param titulacionRepository repositorio de titulaciones
     */
    public TitulacionServiceImpl(TitulacionRepository titulacionRepository) {
        this.titulacionRepository = titulacionRepository;
    }

    /**
     * Obtiene todas las titulaciones.
     * @return lista de titulaciones
     */
    @Override
    public List<Titulacion> listarTitulaciones() {
        return titulacionRepository.findAll();
    }

    /**
     * Busca una titulación por su identificador.
     * @param id identificador de la titulación
     * @return titulación encontrada
     * @throws ResourceNotFoundException si no existe la titulación
     */
    @Override
    public Titulacion buscarPorId(Long id) {
        Optional<Titulacion> titulacion = titulacionRepository.findById(id);

        if (titulacion.isPresent()) {
            return titulacion.get();
        }

        throw new ResourceNotFoundException("No existe una titulación con el ID: " + id);
    }

    /**
     * Guarda una nueva titulación.
     * @param titulacion titulación que se desea guardar
     * @return titulación guardada
     */
    @Override
    public Titulacion guardarTitulacion(Titulacion titulacion) {
        return titulacionRepository.save(titulacion);
    }

    /**
     * Actualiza los datos de una titulación.
     * @param id identificador de la titulación
     * @param titulacion nuevos datos de la titulación
     * @return titulación actualizada
     */
    @Override
    public Titulacion actualizarTitulacion(Long id, Titulacion titulacion) {
        Titulacion titulacionExistente = buscarPorId(id);

        titulacionExistente.setCodigo(titulacion.getCodigo());
        titulacionExistente.setDiminutivo(titulacion.getDiminutivo());
        titulacionExistente.setHorasTotales(titulacion.getHorasTotales());

        return titulacionRepository.save(titulacionExistente);
    }

    /**
     * Elimina una titulación por su identificador.
     * @param id identificador de la titulación
     */
    @Override
    public void eliminarTitulacion(Long id) {
        Titulacion titulacion = buscarPorId(id);
        titulacionRepository.delete(titulacion);
    }
}