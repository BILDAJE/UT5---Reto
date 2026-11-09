
package edu.altair.apicrm.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import edu.altair.apicrm.dtos.requests.ProfesorRequest;
import edu.altair.apicrm.dtos.responses.ProfesorResponse;
import edu.altair.apicrm.entities.Departamento;
import edu.altair.apicrm.entities.Modulo;
import edu.altair.apicrm.entities.Profesor;
import edu.altair.apicrm.services.DepartamentoService;
import edu.altair.apicrm.services.ModuloService;
import edu.altair.apicrm.services.ProfesorService;

/**
 * Controlador REST para gestionar las operaciones de Profesor.
 */
@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;
    private final DepartamentoService departamentoService;
    private final ModuloService moduloService;

    /**
     * Constructor del controlador de profesores.
     * @param profesorService servicio de profesores
     * @param departamentoService servicio de departamentos
     * @param moduloService servicio de módulos
     */
    public ProfesorController(ProfesorService profesorService,
            DepartamentoService departamentoService, ModuloService moduloService) {

        this.profesorService = profesorService;
        this.departamentoService = departamentoService;
        this.moduloService = moduloService;
    }

    /**
     * Obtiene todos los profesores registrados.
     * @return respuesta con la lista de profesores
     */
    @GetMapping
    public ResponseEntity<List<ProfesorResponse>> listarProfesores() {

        List<Profesor> profesores = profesorService.listarProfesores();
        List<ProfesorResponse> respuestas = new ArrayList<>();

        for (Profesor profesor : profesores) {
            respuestas.add(convertirAResponse(profesor));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Busca un profesor por su identificador.
     * @param id identificador del profesor
     * @return respuesta con el profesor encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponse> buscarPorId(@PathVariable Long id) {

        Profesor profesor = profesorService.buscarPorId(id);

        return ResponseEntity.ok(convertirAResponse(profesor));
    }

    /**
     * Guarda un nuevo profesor.
     * @param profesorRequest datos del profesor
     * @return respuesta con el profesor creado
     */
    @PostMapping
    public ResponseEntity<ProfesorResponse> guardarProfesor(
            @RequestBody ProfesorRequest profesorRequest) {

        Profesor profesor = convertirAEntidad(profesorRequest);
        Profesor profesorGuardado = profesorService.guardarProfesor(profesor);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertirAResponse(profesorGuardado));
    }

    /**
     * Actualiza los datos de un profesor.
     * @param id identificador del profesor
     * @param profesorRequest nuevos datos del profesor
     * @return respuesta con el profesor actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponse> actualizarProfesor(
            @PathVariable Long id,
            @RequestBody ProfesorRequest profesorRequest) {

        Profesor profesor = convertirAEntidad(profesorRequest);
        Profesor profesorActualizado = profesorService.actualizarProfesor(id, profesor);

        return ResponseEntity.ok(convertirAResponse(profesorActualizado));
    }

    /**
     * Elimina un profesor por su identificador.
     * @param id identificador del profesor
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Long id) {

        profesorService.eliminarProfesor(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Convierte los datos de una petición en una entidad Profesor.
     * @param profesorRequest datos recibidos en la petición
     * @return entidad Profesor
     */
    private Profesor convertirAEntidad(ProfesorRequest profesorRequest) {

        Profesor profesor = new Profesor();

        profesor.setNombre(profesorRequest.getNombre());
        profesor.setApellidos(profesorRequest.getApellidos());
        profesor.setDni(profesorRequest.getDni());
        profesor.setEmailCentro(profesorRequest.getEmailCentro());
        profesor.setEmailPersonal(profesorRequest.getEmailPersonal());
        profesor.setTelefonoPersonal(profesorRequest.getTelefonoPersonal());

        if (profesorRequest.getIdDepartamento() != null) {
            Departamento departamento =
                    departamentoService.buscarPorId(profesorRequest.getIdDepartamento());
            profesor.setDepartamento(departamento);
        }

        if (profesorRequest.getIdsModulos() != null) {
            Set<Modulo> modulos = new HashSet<>();

            for (Long idModulo : profesorRequest.getIdsModulos()) {
                modulos.add(moduloService.buscarPorId(idModulo));
            }

            profesor.setModulos(modulos);
        }

        return profesor;
    }

    /**
     * Convierte una entidad Profesor en un DTO de respuesta.
     * @param profesor entidad que se desea convertir
     * @return DTO con los datos del profesor
     */
    private ProfesorResponse convertirAResponse(Profesor profesor) {

        ProfesorResponse respuesta = new ProfesorResponse();

        respuesta.setIdProfesor(profesor.getIdProfesor());
        respuesta.setNombre(profesor.getNombre());
        respuesta.setApellidos(profesor.getApellidos());
        respuesta.setDni(profesor.getDni());
        respuesta.setEmailCentro(profesor.getEmailCentro());
        respuesta.setEmailPersonal(profesor.getEmailPersonal());
        respuesta.setTelefonoPersonal(profesor.getTelefonoPersonal());

        if (profesor.getDepartamento() != null) {
            respuesta.setIdDepartamento(profesor.getDepartamento().getIdDepartamento());
        }

        Set<Long> idsModulos = new HashSet<>();

        if (profesor.getModulos() != null) {
            for (Modulo modulo : profesor.getModulos()) {
                idsModulos.add(modulo.getIdModulo());
            }
        }

        respuesta.setIdsModulos(idsModulos);

        return respuesta;
    }
}
