
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

import edu.altair.apicrm.dtos.requests.AlumnoRequest;
import edu.altair.apicrm.dtos.responses.AlumnoResponse;
import edu.altair.apicrm.entities.Alumno;
import edu.altair.apicrm.entities.Familia;
import edu.altair.apicrm.services.AlumnoService;
import edu.altair.apicrm.services.FamiliaService;

/**
 * Controlador REST para gestionar las operaciones de Alumno.
 */
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;
    private final FamiliaService familiaService;

    /**
     * Constructor del controlador de alumnos.
     * @param alumnoService servicio de alumnos
     * @param familiaService servicio de familias
     */
    public AlumnoController(AlumnoService alumnoService, FamiliaService familiaService) {
        this.alumnoService = alumnoService;
        this.familiaService = familiaService;
    }

    /**
     * Obtiene todos los alumnos.
     * @return respuesta con la lista de alumnos
     */
    @GetMapping
    public ResponseEntity<List<AlumnoResponse>> listarAlumnos() {

        List<Alumno> alumnos = alumnoService.listarAlumnos();
        List<AlumnoResponse> respuestas = new ArrayList<>();

        for (Alumno alumno : alumnos) {
            respuestas.add(convertirAResponse(alumno));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Busca un alumno por su identificador.
     * @param id identificador del alumno
     * @return respuesta con el alumno encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponse> buscarPorId(@PathVariable Long id) {

        Alumno alumno = alumnoService.buscarPorId(id);

        return ResponseEntity.ok(convertirAResponse(alumno));
    }

    /**
     * Guarda un nuevo alumno.
     * @param alumnoRequest datos del alumno que se desea guardar
     * @return respuesta con el alumno creado
     */
    @PostMapping
    public ResponseEntity<AlumnoResponse> guardarAlumno(
            @RequestBody AlumnoRequest alumnoRequest) {

        Alumno alumno = convertirAEntidad(alumnoRequest);

        Alumno alumnoGuardado = alumnoService.guardarAlumno(alumno);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertirAResponse(alumnoGuardado));
    }

    /**
     * Actualiza los datos de un alumno.
     * @param id identificador del alumno
     * @param alumnoRequest nuevos datos del alumno
     * @return respuesta con el alumno actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponse> actualizarAlumno(
            @PathVariable Long id,
            @RequestBody AlumnoRequest alumnoRequest) {

        Alumno alumno = convertirAEntidad(alumnoRequest);

        Alumno alumnoActualizado = alumnoService.actualizarAlumno(id, alumno);

        return ResponseEntity.ok(convertirAResponse(alumnoActualizado));
    }

    /**
     * Elimina un alumno por su identificador.
     * @param id identificador del alumno
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {

        alumnoService.eliminarAlumno(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Convierte los datos de una petición en una entidad Alumno.
     * @param alumnoRequest datos recibidos en la petición
     * @return entidad Alumno
     */
    private Alumno convertirAEntidad(AlumnoRequest alumnoRequest) {

        Alumno alumno = new Alumno();

        alumno.setNombre(alumnoRequest.getNombre());
        alumno.setApellidos(alumnoRequest.getApellidos());
        alumno.setDni(alumnoRequest.getDni());
        alumno.setNumeroSs(alumnoRequest.getNumeroSs());
        alumno.setEmailPersonal(alumnoRequest.getEmailPersonal());
        alumno.setTelefonoPersonal(alumnoRequest.getTelefonoPersonal());
        alumno.setFechaAlta(alumnoRequest.getFechaAlta());
        alumno.setFechaBaja(alumnoRequest.getFechaBaja());
        alumno.setEmailCentro(alumnoRequest.getEmailCentro());

        if (alumnoRequest.getIdFamilia() != null) {
            Familia familia = familiaService.buscarPorId(alumnoRequest.getIdFamilia());
            alumno.setFamilia(familia);
        }

        return alumno;
    }

    /**
     * Convierte una entidad Alumno en un DTO de respuesta.
     * @param alumno entidad que se desea convertir
     * @return DTO con los datos del alumno
     */
    private AlumnoResponse convertirAResponse(Alumno alumno) {

        AlumnoResponse respuesta = new AlumnoResponse();

        respuesta.setIdAlumno(alumno.getIdAlumno());
        respuesta.setNombre(alumno.getNombre());
        respuesta.setApellidos(alumno.getApellidos());
        respuesta.setDni(alumno.getDni());
        respuesta.setNumeroSs(alumno.getNumeroSs());
        respuesta.setEmailPersonal(alumno.getEmailPersonal());
        respuesta.setTelefonoPersonal(alumno.getTelefonoPersonal());
        respuesta.setFechaAlta(alumno.getFechaAlta());
        respuesta.setFechaBaja(alumno.getFechaBaja());
        respuesta.setEmailCentro(alumno.getEmailCentro());

        if (alumno.getFamilia() != null) {
            respuesta.setIdFamilia(alumno.getFamilia().getIdFamilia());
        }

        return respuesta;
    }
}
