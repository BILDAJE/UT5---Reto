
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

import edu.altair.apicrm.dtos.requests.TitulacionRequest;
import edu.altair.apicrm.dtos.responses.TitulacionResponse;
import edu.altair.apicrm.entities.Titulacion;
import edu.altair.apicrm.services.TitulacionService;

/**
 * Controlador REST para gestionar las operaciones de Titulacion.
 */
@RestController
@RequestMapping("/api/titulaciones")
public class TitulacionController {

    private final TitulacionService titulacionService;

    /**
     * Constructor del controlador de titulaciones.
     * @param titulacionService servicio de titulaciones
     */
    public TitulacionController(TitulacionService titulacionService) {
        this.titulacionService = titulacionService;
    }

    /**
     * Obtiene todas las titulaciones registradas.
     * @return respuesta con la lista de titulaciones
     */
    @GetMapping
    public ResponseEntity<List<TitulacionResponse>> listarTitulaciones() {

        List<Titulacion> titulaciones = titulacionService.listarTitulaciones();
        List<TitulacionResponse> respuestas = new ArrayList<>();

        for (Titulacion titulacion : titulaciones) {
            respuestas.add(convertirAResponse(titulacion));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Busca una titulación por su identificador.
     * @param id identificador de la titulación
     * @return respuesta con la titulación encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<TitulacionResponse> buscarPorId(@PathVariable Long id) {

        Titulacion titulacion = titulacionService.buscarPorId(id);

        return ResponseEntity.ok(convertirAResponse(titulacion));
    }

    /**
     * Guarda una nueva titulación.
     * @param titulacionRequest datos de la titulación
     * @return respuesta con la titulación creada
     */
    @PostMapping
    public ResponseEntity<TitulacionResponse> guardarTitulacion(
            @RequestBody TitulacionRequest titulacionRequest) {

        Titulacion titulacion = convertirAEntidad(titulacionRequest);
        Titulacion titulacionGuardada = titulacionService.guardarTitulacion(titulacion);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertirAResponse(titulacionGuardada));
    }

    /**
     * Actualiza los datos de una titulación.
     * @param id identificador de la titulación
     * @param titulacionRequest nuevos datos de la titulación
     * @return respuesta con la titulación actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<TitulacionResponse> actualizarTitulacion(
            @PathVariable Long id,
            @RequestBody TitulacionRequest titulacionRequest) {

        Titulacion titulacion = convertirAEntidad(titulacionRequest);
        Titulacion titulacionActualizada =
                titulacionService.actualizarTitulacion(id, titulacion);

        return ResponseEntity.ok(convertirAResponse(titulacionActualizada));
    }

    /**
     * Elimina una titulación por su identificador.
     * @param id identificador de la titulación
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTitulacion(@PathVariable Long id) {

        titulacionService.eliminarTitulacion(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Convierte los datos de una petición en una entidad Titulacion.
     * @param titulacionRequest datos recibidos en la petición
     * @return entidad Titulacion
     */
    private Titulacion convertirAEntidad(TitulacionRequest titulacionRequest) {

        Titulacion titulacion = new Titulacion();

        titulacion.setCodigo(titulacionRequest.getCodigo());
        titulacion.setDiminutivo(titulacionRequest.getDiminutivo());
        titulacion.setHorasTotales(titulacionRequest.getHorasTotales());

        return titulacion;
    }

    /**
     * Convierte una entidad Titulacion en un DTO de respuesta.
     * @param titulacion entidad que se desea convertir
     * @return DTO con los datos de la titulación
     */
    private TitulacionResponse convertirAResponse(Titulacion titulacion) {

        TitulacionResponse respuesta = new TitulacionResponse();

        respuesta.setIdTitulacion(titulacion.getIdTitulacion());
        respuesta.setCodigo(titulacion.getCodigo());
        respuesta.setDiminutivo(titulacion.getDiminutivo());
        respuesta.setHorasTotales(titulacion.getHorasTotales());

        return respuesta;
    }
}
