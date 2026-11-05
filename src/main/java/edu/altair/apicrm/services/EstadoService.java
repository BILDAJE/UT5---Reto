package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.apicrm.entities.Estado;

/**
 * Interfaz de servicio para gestionar la lógica de negocio de Estado.
 */
public interface EstadoService {

    /**
     * Obtiene todos los estados.
     * @return lista de estados
     */
    List<Estado> listarEstados();

    /**
     * Busca un estado por su identificador.
     * @param id identificador del estado
     * @return estado encontrado
     */
    Estado buscarPorId(Long id);

    /**
     * Guarda un nuevo estado.
     * @param estado estado que se desea guardar
     * @return estado guardado
     */
    Estado guardarEstado(Estado estado);

    /**
     * Actualiza los datos de un estado.
     * @param id identificador del estado
     * @param estado nuevos datos del estado
     * @return estado actualizado
     */
    Estado actualizarEstado(Long id, Estado estado);

    /**
     * Elimina un estado por su identificador.
     * @param id identificador del estado
     */
    void eliminarEstado(Long id);
}