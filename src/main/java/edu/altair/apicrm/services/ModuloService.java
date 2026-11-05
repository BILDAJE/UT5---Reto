package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.apicrm.entities.Modulo;

/**
 * Interfaz de servicio para gestionar la lógica de negocio de Modulo.
 */
public interface ModuloService {

    /**
     * Obtiene todos los módulos.
     * @return lista de módulos
     */
    List<Modulo> listarModulos();

    /**
     * Busca un módulo por su identificador.
     * @param id identificador del módulo
     * @return módulo encontrado
     */
    Modulo buscarPorId(Long id);

    /**
     * Guarda un nuevo módulo.
     * @param modulo módulo que se desea guardar
     * @return módulo guardado
     */
    Modulo guardarModulo(Modulo modulo);

    /**
     * Actualiza los datos de un módulo.
     * @param id identificador del módulo
     * @param modulo nuevos datos del módulo
     * @return módulo actualizado
     */
    Modulo actualizarModulo(Long id, Modulo modulo);

    /**
     * Elimina un módulo por su identificador.
     * @param id identificador del módulo
     */
    void eliminarModulo(Long id);
}