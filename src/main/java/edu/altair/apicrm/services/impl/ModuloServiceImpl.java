package edu.altair.apicrm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.altair.apicrm.entities.Modulo;
import edu.altair.apicrm.repositories.ModuloRepository;
import edu.altair.apicrm.services.ModuloService;

/**
 * Implementación del servicio para gestionar la lógica de negocio de Modulo.
 */
@Service
public class ModuloServiceImpl implements ModuloService {

    private final ModuloRepository moduloRepository;

    /**
     * Constructor del servicio de módulos.
     * @param moduloRepository repositorio de módulos
     */
    public ModuloServiceImpl(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    /**
     * Obtiene todos los módulos.
     * @return lista de módulos
     */
    @Override
    public List<Modulo> listarModulos() {
        return moduloRepository.findAll();
    }

    /**
     * Busca un módulo por su identificador.
     * @param id identificador del módulo
     * @return módulo encontrado
     * @throws IllegalArgumentException si no existe el módulo
     */
    @Override
    public Modulo buscarPorId(Long id) {
        if (moduloRepository.existsById(id)) {
            return moduloRepository.findById(id).get();
        }

        throw new IllegalArgumentException("No existe un módulo con el ID: " + id);
    }

    /**
     * Guarda un nuevo módulo.
     * @param modulo módulo que se desea guardar
     * @return módulo guardado
     */
    @Override
    public Modulo guardarModulo(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    /**
     * Actualiza los datos de un módulo.
     * @param id identificador del módulo
     * @param modulo nuevos datos del módulo
     * @return módulo actualizado
     */
    @Override
    public Modulo actualizarModulo(Long id, Modulo modulo) {
        Modulo moduloExistente = buscarPorId(id);

        moduloExistente.setCodigo(modulo.getCodigo());
        moduloExistente.setNombre(modulo.getNombre());

        return moduloRepository.save(moduloExistente);
    }

    /**
     * Elimina un módulo por su identificador.
     * @param id identificador del módulo
     */
    @Override
    public void eliminarModulo(Long id) {
        Modulo modulo = buscarPorId(id);
        moduloRepository.delete(modulo);
    }
}