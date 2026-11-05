package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.apicrm.entities.Familia;

/**
 * Interfaz de servicio para gestionar la lógica de negocio de Familia.
 */
public interface FamiliaService {

    /**
     * Obtiene todas las familias.
     * @return lista de familias
     */
    List<Familia> listarFamilias();

    /**
     * Busca una familia por su identificador.
     * @param id identificador de la familia
     * @return familia encontrada
     */
    Familia buscarPorId(Long id);

    /**
     * Guarda una nueva familia.
     * @param familia familia que se desea guardar
     * @return familia guardada
     */
    Familia guardarFamilia(Familia familia);

    /**
     * Actualiza los datos de una familia.
     * @param id identificador de la familia
     * @param familia nuevos datos de la familia
     * @return familia actualizada
     */
    Familia actualizarFamilia(Long id, Familia familia);

    /**
     * Elimina una familia por su identificador.
     * @param id identificador de la familia
     */
    void eliminarFamilia(Long id);
}