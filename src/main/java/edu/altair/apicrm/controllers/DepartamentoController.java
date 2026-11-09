
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

import edu.altair.apicrm.dtos.requests.DepartamentoRequest;
import edu.altair.apicrm.dtos.responses.DepartamentoResponse;
import edu.altair.apicrm.entities.Departamento;
import edu.altair.apicrm.services.DepartamentoService;

/**
 * Controlador REST para gestionar las operaciones de Departamento.
 */
@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    /**
     * Constructor del controlador de departamentos.
     * @param departamentoService servicio de departamentos
     */
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    /**
     * Obtiene todos los departamentos registrados.
     * @return respuesta con la lista de departamentos
     */
    @GetMapping
    public ResponseEntity<List<DepartamentoResponse>> listarDepartamentos() {

        List<Departamento> departamentos = departamentoService.listarDepartamentos();
        List<DepartamentoResponse> respuestas = new ArrayList<>();

        for (Departamento departamento : departamentos) {
            respuestas.add(convertirAResponse(departamento));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Busca un departamento por su identificador.
     * @param id identificador del departamento
     * @return respuesta con el departamento encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponse> buscarPorId(@PathVariable Long id) {

        Departamento departamento = departamentoService.buscarPorId(id);

        return ResponseEntity.ok(convertirAResponse(departamento));
    }

    /**
     * Guarda un nuevo departamento.
     * @param departamentoRequest datos del departamento
     * @return respuesta con el departamento creado
     */
    @PostMapping
    public ResponseEntity<DepartamentoResponse> guardarDepartamento(
            @RequestBody DepartamentoRequest departamentoRequest) {

        Departamento departamento = convertirAEntidad(departamentoRequest);
        Departamento departamentoGuardado = departamentoService.guardarDepartamento(departamento);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertirAResponse(departamentoGuardado));
    }

    /**
     * Actualiza los datos de un departamento.
     * @param id identificador del departamento
     * @param departamentoRequest nuevos datos del departamento
     * @return respuesta con el departamento actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoResponse> actualizarDepartamento(
            @PathVariable Long id,
            @RequestBody DepartamentoRequest departamentoRequest) {

        Departamento departamento = convertirAEntidad(departamentoRequest);
        Departamento departamentoActualizado =
                departamentoService.actualizarDepartamento(id, departamento);

        return ResponseEntity.ok(convertirAResponse(departamentoActualizado));
    }

    /**
     * Elimina un departamento por su identificador.
     * @param id identificador del departamento
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable Long id) {

        departamentoService.eliminarDepartamento(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Convierte los datos de una petición en una entidad Departamento.
     * @param departamentoRequest datos recibidos en la petición
     * @return entidad Departamento
     */
    private Departamento convertirAEntidad(DepartamentoRequest departamentoRequest) {

        Departamento departamento = new Departamento();

        departamento.setCodigo(departamentoRequest.getCodigo());
        departamento.setNombre(departamentoRequest.getNombre());
        departamento.setDescripcion(departamentoRequest.getDescripcion());
        departamento.setTelefono(departamentoRequest.getTelefono());

        return departamento;
    }

    /**
     * Convierte una entidad Departamento en un DTO de respuesta.
     * @param departamento entidad que se desea convertir
     * @return DTO con los datos del departamento
     */
    private DepartamentoResponse convertirAResponse(Departamento departamento) {

        DepartamentoResponse respuesta = new DepartamentoResponse();

        respuesta.setIdDepartamento(departamento.getIdDepartamento());
        respuesta.setCodigo(departamento.getCodigo());
        respuesta.setNombre(departamento.getNombre());
        respuesta.setDescripcion(departamento.getDescripcion());
        respuesta.setTelefono(departamento.getTelefono());

        return respuesta;
    }
}
