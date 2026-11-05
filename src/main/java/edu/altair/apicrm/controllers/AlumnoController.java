package edu.altair.apicrm.controllers;

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
import edu.altair.apicrm.entities.Alumno;
import edu.altair.apicrm.services.AlumnoService;

/**
 * Controlador REST para gestionar las operaciones de Alumno.
 */
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    /**
     * Constructor del controlador de alumnos.
     * @param alumnoService servicio de alumnos
     */
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    /**
     * Obtiene todos los alumnos.
     * @return respuesta con la lista de alumnos
     */
    @GetMapping
    public ResponseEntity<List<Alumno>> listarAlumnos() {
        return ResponseEntity.ok(alumnoService.listarAlumnos());
    }

    /**
     * Busca un alumno por su identificador.
     * @param id identificador del alumno
     * @return respuesta con el alumno encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.buscarPorId(id));
    }

    /**
     * Guarda un nuevo alumno.
     * @param alumnoRequest datos del alumno que se desea guardar
     * @return respuesta con el alumno creado
     */
    @PostMapping
    public ResponseEntity<Alumno> guardarAlumno(@RequestBody AlumnoRequest alumnoRequest) {

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

        Alumno alumnoGuardado = alumnoService.guardarAlumno(alumno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoGuardado);
    }

    /**
     * Actualiza los datos de un alumno.
     * @param id identificador del alumno
     * @param alumnoRequest nuevos datos del alumno
     * @return respuesta con el alumno actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(
            @PathVariable Long id,
            @RequestBody AlumnoRequest alumnoRequest) {

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

        Alumno alumnoActualizado = alumnoService.actualizarAlumno(id, alumno);

        return ResponseEntity.ok(alumnoActualizado);
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
}