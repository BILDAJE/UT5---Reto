
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

import edu.altair.apicrm.dtos.requests.EstadoRequest;
import edu.altair.apicrm.dtos.responses.EstadoResponse;
import edu.altair.apicrm.entities.Estado;
import edu.altair.apicrm.services.EstadoService;

/**
 * Controlador REST para gestionar las operaciones de Estado.
 */
@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    private final EstadoService estadoService;

    /**
     * Constructor del controlador de estados.
     * @param estadoService servicio de estados
     */
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    /**
     * Obtiene todos los estados registrados.
     * @return respuesta con la lista de estados
     */
    @GetMapping
    public ResponseEntity<List<EstadoResponse>> listarEstados() {

        List<Estado> estados = estadoService.listarEstados();
        List<EstadoResponse> respuestas = new ArrayList<>();

        for (Estado estado : estados) {
            respuestas.add(convertirAResponse(estado));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Busca un estado por su identificador.
     * @param id identificador del estado
     * @return respuesta con el estado encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponse> buscarPorId(@PathVariable Long id) {

        Estado estado = estadoService.buscarPorId(id);

        return ResponseEntity.ok(convertirAResponse(estado));
    }

    /**
     * Guarda un nuevo estado.
     * @param estadoRequest datos del estado
     * @return respuesta con el estado creado
     */
    @PostMapping
    public ResponseEntity<EstadoResponse> guardarEstado(
            @RequestBody EstadoRequest estadoRequest) {

        Estado estado = convertirAEntidad(estadoRequest);
        Estado estadoGuardado = estadoService.guardarEstado(estado);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertirAResponse(estadoGuardado));
    }

    /**
     * Actualiza los datos de un estado.
     * @param id identificador del estado
     * @param estadoRequest nuevos datos del estado
     * @return respuesta con el estado actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<EstadoResponse> actualizarEstado(
            @PathVariable Long id,
            @RequestBody EstadoRequest estadoRequest) {

        Estado estado = convertirAEntidad(estadoRequest);
        Estado estadoActualizado = estadoService.actualizarEstado(id, estado);

        return ResponseEntity.ok(convertirAResponse(estadoActualizado));
    }

    /**
     * Elimina un estado por su identificador.
     * @param id identificador del estado
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable Long id) {

        estadoService.eliminarEstado(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Convierte los datos de una petición en una entidad Estado.
     * @param estadoRequest datos recibidos en la petición
     * @return entidad Estado
     */
    private Estado convertirAEntidad(EstadoRequest estadoRequest) {

        Estado estado = new Estado();

        estado.setNombre(estadoRequest.getNombre());
        estado.setDescripcion(estadoRequest.getDescripcion());

        return estado;
    }

    /**
     * Convierte una entidad Estado en un DTO de respuesta.
     * @param estado entidad que se desea convertir
     * @return DTO con los datos del estado
     */
    private EstadoResponse convertirAResponse(Estado estado) {

        EstadoResponse respuesta = new EstadoResponse();

        respuesta.setIdEstado(estado.getIdEstado());
        respuesta.setNombre(estado.getNombre());
        respuesta.setDescripcion(estado.getDescripcion());

        return respuesta;
    }
}
