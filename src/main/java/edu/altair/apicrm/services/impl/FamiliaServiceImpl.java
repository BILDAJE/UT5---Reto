package edu.altair.apicrm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.altair.apicrm.entities.Familia;
import edu.altair.apicrm.repositories.FamiliaRepository;
import edu.altair.apicrm.services.FamiliaService;

/**
 * Implementación del servicio para gestionar la lógica de negocio de Familia.
 */
@Service
public class FamiliaServiceImpl implements FamiliaService {

    private final FamiliaRepository familiaRepository;

    /**
     * Constructor del servicio de familias.
     * @param familiaRepository repositorio de familias
     */
    public FamiliaServiceImpl(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    /**
     * Obtiene todas las familias.
     * @return lista de familias
     */
    @Override
    public List<Familia> listarFamilias() {
        return familiaRepository.findAll();
    }

    /**
     * Busca una familia por su identificador.
     * @param id identificador de la familia
     * @return familia encontrada
     * @throws IllegalArgumentException si no existe la familia
     */
    @Override
    public Familia buscarPorId(Long id) {
        if (familiaRepository.existsById(id)) {
            return familiaRepository.findById(id).get();
        }

        throw new IllegalArgumentException("No existe una familia con el ID: " + id);
    }

    /**
     * Guarda una nueva familia.
     *
     * @param familia familia que se desea guardar
     * @return familia guardada
     */
    @Override
    public Familia guardarFamilia(Familia familia) {
        return familiaRepository.save(familia);
    }

    /**
     * Actualiza los datos de una familia.
     * @param id identificador de la familia
     * @param familia nuevos datos de la familia
     * @return familia actualizada
     */
    @Override
    public Familia actualizarFamilia(Long id, Familia familia) {
        Familia familiaExistente = buscarPorId(id);

        familiaExistente.setNombrePadre(familia.getNombrePadre());
        familiaExistente.setNombreMadre(familia.getNombreMadre());
        familiaExistente.setApellidosPadre(familia.getApellidosPadre());
        familiaExistente.setApellidosMadre(familia.getApellidosMadre());
        familiaExistente.setEmailPadre(familia.getEmailPadre());
        familiaExistente.setEmailMadre(familia.getEmailMadre());
        familiaExistente.setTelefonoPadre(familia.getTelefonoPadre());
        familiaExistente.setTelefonoMadre(familia.getTelefonoMadre());
        familiaExistente.setDireccionPadre(familia.getDireccionPadre());
        familiaExistente.setDireccionMadre(familia.getDireccionMadre());
        familiaExistente.setCodigoPostalPadre(familia.getCodigoPostalPadre());
        familiaExistente.setCodigoPostalMadre(familia.getCodigoPostalMadre());
        familiaExistente.setMunicipioPadre(familia.getMunicipioPadre());
        familiaExistente.setMunicipioMadre(familia.getMunicipioMadre());
        familiaExistente.setProvinciaPadre(familia.getProvinciaPadre());
        familiaExistente.setProvinciaMadre(familia.getProvinciaMadre());
        familiaExistente.setSonSeparados(familia.getSonSeparados());
        familiaExistente.setEsCompartida(familia.getEsCompartida());
        familiaExistente.setEsPadre(familia.getEsPadre());
        familiaExistente.setEsMadre(familia.getEsMadre());

        return familiaRepository.save(familiaExistente);
    }

    /**
     * Elimina una familia por su identificador.
     * @param id identificador de la familia
     */
    @Override
    public void eliminarFamilia(Long id) {
        Familia familia = buscarPorId(id);
        familiaRepository.delete(familia);
    }
}