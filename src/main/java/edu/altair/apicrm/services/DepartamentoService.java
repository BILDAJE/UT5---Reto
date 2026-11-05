package edu.altair.apicrm.services;

import java.util.List;

import edu.altair.apicrm.entities.Departamento;

/**
 * Interfaz de servicio para gestionar la lógica de negocio de Departamento.
 */
public interface DepartamentoService {

    /**
     * Obtiene todos los departamentos.
     * @return lista de departamentos
     */
    List<Departamento> listarDepartamentos();

    /**
     * Busca un departamento por su identificador.
     * @param id identificador del departamento
     * @return departamento encontrado
     */
    Departamento buscarPorId(Long id);

    /**
     * Guarda un nuevo departamento.
     * @param departamento departamento que se desea guardar
     * @return departamento guardado
     */
    Departamento guardarDepartamento(Departamento departamento);

    /**
     * Actualiza los datos de un departamento.
     * @param id identificador del departamento
     * @param departamento nuevos datos del departamento
     * @return departamento actualizado
     */
    Departamento actualizarDepartamento(Long id, Departamento departamento);

    /**
     * Elimina un departamento por su identificador.
     * @param id identificador del departamento
     */
    void eliminarDepartamento(Long id);
}