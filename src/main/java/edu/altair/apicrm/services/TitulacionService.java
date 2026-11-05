package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.apicrm.entities.Titulacion;

/**
 * Interfaz de servicio para gestionar la lógica de negocio de Titulacion.
 */
public interface TitulacionService {

    /**
     * Obtiene todas las titulaciones.
     * @return lista de titulaciones
     */
    List<Titulacion> listarTitulaciones();

    /**
     * Busca una titulación por su identificador.
     * @param id identificador de la titulación
     * @return titulación encontrada
     */
    Titulacion buscarPorId(Long id);

    /**
     * Guarda una nueva titulación.
     * @param titulacion titulación que se desea guardar
     * @return titulación guardada
     */
    Titulacion guardarTitulacion(Titulacion titulacion);

    /**
     * Actualiza los datos de una titulación.
     * @param id identificador de la titulación
     * @param titulacion nuevos datos de la titulación
     * @return titulación actualizada
     */
    Titulacion actualizarTitulacion(Long id, Titulacion titulacion);

    /**
     * Elimina una titulación por su identificador.
     * @param id identificador de la titulación
     */
    void eliminarTitulacion(Long id);
}