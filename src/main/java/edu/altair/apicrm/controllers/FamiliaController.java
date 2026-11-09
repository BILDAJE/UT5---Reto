
package edu.altair.apicrm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.apicrm.dtos.requests.FamiliaRequest;
import edu.altair.apicrm.dtos.responses.FamiliaResponse;
import edu.altair.apicrm.entities.Familia;
import edu.altair.apicrm.services.FamiliaService;

/**
 * Controlador REST para gestionar las operaciones de Familia.
 * Permite crear, consultar, actualizar y eliminar familias.
 */
@RestController
@RequestMapping("/api/familias")
public class FamiliaController {

    private final FamiliaService familiaService;

    /**
     * Constructor del controlador de familias.
     * @param familiaService servicio de familias
     */
    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    /**
     * Obtiene todas las familias registradas.
     * @return respuesta con la lista de familias
     */
    @GetMapping
    public ResponseEntity<List<FamiliaResponse>> listarFamilias() {

        List<Familia> familias = familiaService.listarFamilias();
        List<FamiliaResponse> respuestas = new ArrayList<>();

        for (Familia familia : familias) {
            respuestas.add(convertirAResponse(familia));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Busca una familia por su identificador.
     * @param id identificador de la familia
     * @return respuesta con la familia encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<FamiliaResponse> buscarPorId(@PathVariable Long id) {

        Familia familia = familiaService.buscarPorId(id);

        return ResponseEntity.ok(convertirAResponse(familia));
    }

    /**
     * Guarda una nueva familia.
     * @param familiaRequest datos de la familia que se desea guardar
     * @return respuesta con la familia creada
     */
    @PostMapping
    public ResponseEntity<FamiliaResponse> guardarFamilia(
            @RequestBody FamiliaRequest familiaRequest) {

        Familia familia = convertirAEntidad(familiaRequest);
        Familia familiaGuardada = familiaService.guardarFamilia(familia);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertirAResponse(familiaGuardada));
    }

    /**
     * Actualiza los datos de una familia.
     * @param id identificador de la familia
     * @param familiaRequest nuevos datos de la familia
     * @return respuesta con la familia actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<FamiliaResponse> actualizarFamilia(
            @PathVariable Long id,
            @RequestBody FamiliaRequest familiaRequest) {

        Familia familia = convertirAEntidad(familiaRequest);
        Familia familiaActualizada = familiaService.actualizarFamilia(id, familia);

        return ResponseEntity.ok(convertirAResponse(familiaActualizada));
    }

    /**
     * Elimina una familia por su identificador.
     * @param id identificador de la familia
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFamilia(@PathVariable Long id) {

        familiaService.eliminarFamilia(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Convierte los datos de una petición en una entidad Familia.
     * @param familiaRequest datos recibidos en la petición
     * @return entidad Familia
     */
    private Familia convertirAEntidad(FamiliaRequest familiaRequest) {

        Familia familia = new Familia();

        familia.setNombrePadre(familiaRequest.getNombrePadre());
        familia.setNombreMadre(familiaRequest.getNombreMadre());
        familia.setApellidosPadre(familiaRequest.getApellidosPadre());
        familia.setApellidosMadre(familiaRequest.getApellidosMadre());
        familia.setEmailPadre(familiaRequest.getEmailPadre());
        familia.setEmailMadre(familiaRequest.getEmailMadre());
        familia.setTelefonoPadre(familiaRequest.getTelefonoPadre());
        familia.setTelefonoMadre(familiaRequest.getTelefonoMadre());
        familia.setDireccionPadre(familiaRequest.getDireccionPadre());
        familia.setDireccionMadre(familiaRequest.getDireccionMadre());
        familia.setCodigoPostalPadre(familiaRequest.getCodigoPostalPadre());
        familia.setCodigoPostalMadre(familiaRequest.getCodigoPostalMadre());
        familia.setMunicipioPadre(familiaRequest.getMunicipioPadre());
        familia.setMunicipioMadre(familiaRequest.getMunicipioMadre());
        familia.setProvinciaPadre(familiaRequest.getProvinciaPadre());
        familia.setProvinciaMadre(familiaRequest.getProvinciaMadre());
        familia.setSonSeparados(familiaRequest.getSonSeparados());
        familia.setEsCompartida(familiaRequest.getEsCompartida());
        familia.setEsPadre(familiaRequest.getEsPadre());
        familia.setEsMadre(familiaRequest.getEsMadre());

        return familia;
    }

    /**
     * Convierte una entidad Familia en un DTO de respuesta.
     * @param familia entidad que se desea convertir
     * @return DTO con los datos de la familia
     */
    private FamiliaResponse convertirAResponse(Familia familia) {

        FamiliaResponse respuesta = new FamiliaResponse();

        respuesta.setIdFamilia(familia.getIdFamilia());
        respuesta.setNombrePadre(familia.getNombrePadre());
        respuesta.setNombreMadre(familia.getNombreMadre());
        respuesta.setApellidosPadre(familia.getApellidosPadre());
        respuesta.setApellidosMadre(familia.getApellidosMadre());
        respuesta.setEmailPadre(familia.getEmailPadre());
        respuesta.setEmailMadre(familia.getEmailMadre());
        respuesta.setTelefonoPadre(familia.getTelefonoPadre());
        respuesta.setTelefonoMadre(familia.getTelefonoMadre());
        respuesta.setDireccionPadre(familia.getDireccionPadre());
        respuesta.setDireccionMadre(familia.getDireccionMadre());
        respuesta.setCodigoPostalPadre(familia.getCodigoPostalPadre());
        respuesta.setCodigoPostalMadre(familia.getCodigoPostalMadre());
        respuesta.setMunicipioPadre(familia.getMunicipioPadre());
        respuesta.setMunicipioMadre(familia.getMunicipioMadre());
        respuesta.setProvinciaPadre(familia.getProvinciaPadre());
        respuesta.setProvinciaMadre(familia.getProvinciaMadre());
        respuesta.setSonSeparados(familia.getSonSeparados());
        respuesta.setEsCompartida(familia.getEsCompartida());
        respuesta.setEsPadre(familia.getEsPadre());
        respuesta.setEsMadre(familia.getEsMadre());

        return respuesta;
    }
}
