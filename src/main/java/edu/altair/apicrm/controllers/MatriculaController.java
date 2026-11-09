
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

import edu.altair.apicrm.dtos.requests.MatriculaRequest;
import edu.altair.apicrm.dtos.responses.MatriculaResponse;
import edu.altair.apicrm.entities.Alumno;
import edu.altair.apicrm.entities.Estado;
import edu.altair.apicrm.entities.Matricula;
import edu.altair.apicrm.entities.Modulo;
import edu.altair.apicrm.services.AlumnoService;
import edu.altair.apicrm.services.EstadoService;
import edu.altair.apicrm.services.MatriculaService;
import edu.altair.apicrm.services.ModuloService;

/**
 * Controlador REST para gestionar las operaciones de Matricula.
 */
@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final AlumnoService alumnoService;
    private final ModuloService moduloService;
    private final EstadoService estadoService;

    /**
     * Constructor del controlador de matrículas.
     * @param matriculaService servicio de matrículas
     * @param alumnoService servicio de alumnos
     * @param moduloService servicio de módulos
     * @param estadoService servicio de estados
     */
    public MatriculaController(MatriculaService matriculaService,
            AlumnoService alumnoService, ModuloService moduloService,
            EstadoService estadoService) {

        this.matriculaService = matriculaService;
        this.alumnoService = alumnoService;
        this.moduloService = moduloService;
        this.estadoService = estadoService;
    }

    /**
     * Obtiene todas las matrículas registradas.
     * @return respuesta con la lista de matrículas
     */
    @GetMapping
    public ResponseEntity<List<MatriculaResponse>> listarMatriculas() {

        List<Matricula> matriculas = matriculaService.listarMatriculas();
        List<MatriculaResponse> respuestas = new ArrayList<>();

        for (Matricula matricula : matriculas) {
            respuestas.add(convertirAResponse(matricula));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Busca una matrícula por su identificador.
     * @param id identificador de la matrícula
     * @return respuesta con la matrícula encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponse> buscarPorId(@PathVariable Long id) {

        Matricula matricula = matriculaService.buscarPorId(id);

        return ResponseEntity.ok(convertirAResponse(matricula));
    }

    /**
     * Obtiene las matrículas de un alumno.
     * @param idAlumno identificador del alumno
     * @return respuesta con las matrículas del alumno
     */
    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity<List<MatriculaResponse>> buscarPorAlumno(
            @PathVariable Long idAlumno) {

        List<Matricula> matriculas = matriculaService.buscarPorAlumno(idAlumno);
        List<MatriculaResponse> respuestas = new ArrayList<>();

        for (Matricula matricula : matriculas) {
            respuestas.add(convertirAResponse(matricula));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Guarda una nueva matrícula.
     * @param matriculaRequest datos de la matrícula
     * @return respuesta con la matrícula creada
     */
    @PostMapping
    public ResponseEntity<MatriculaResponse> guardarMatricula(
            @RequestBody MatriculaRequest matriculaRequest) {

        Matricula matricula = convertirAEntidad(matriculaRequest);
        Matricula matriculaGuardada = matriculaService.guardarMatricula(matricula);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertirAResponse(matriculaGuardada));
    }

    /**
     * Actualiza los datos de una matrícula.
     * @param id identificador de la matrícula
     * @param matriculaRequest nuevos datos de la matrícula
     * @return respuesta con la matrícula actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<MatriculaResponse> actualizarMatricula(
            @PathVariable Long id,
            @RequestBody MatriculaRequest matriculaRequest) {

        Matricula matricula = convertirAEntidad(matriculaRequest);
        Matricula matriculaActualizada =
                matriculaService.actualizarMatricula(id, matricula);

        return ResponseEntity.ok(convertirAResponse(matriculaActualizada));
    }

    /**
     * Elimina una matrícula por su identificador.
     * @param id identificador de la matrícula
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMatricula(@PathVariable Long id) {

        matriculaService.eliminarMatricula(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Convierte los datos de una petición en una entidad Matricula.
     * @param matriculaRequest datos recibidos en la petición
     * @return entidad Matricula
     */
    private Matricula convertirAEntidad(MatriculaRequest matriculaRequest) {

        Matricula matricula = new Matricula();

        Alumno alumno = alumnoService.buscarPorId(matriculaRequest.getIdAlumno());
        Modulo modulo = moduloService.buscarPorId(matriculaRequest.getIdModulo());
        Estado estado = estadoService.buscarPorId(matriculaRequest.getIdEstado());

        matricula.setAlumno(alumno);
        matricula.setModulo(modulo);
        matricula.setEstado(estado);

        return matricula;
    }

    /**
     * Convierte una entidad Matricula en un DTO de respuesta.
     * @param matricula entidad que se desea convertir
     * @return DTO con los datos de la matrícula
     */
    private MatriculaResponse convertirAResponse(Matricula matricula) {

        MatriculaResponse respuesta = new MatriculaResponse();

        respuesta.setIdMatricula(matricula.getIdMatricula());
        respuesta.setIdAlumno(matricula.getAlumno().getIdAlumno());
        respuesta.setIdModulo(matricula.getModulo().getIdModulo());
        respuesta.setIdEstado(matricula.getEstado().getIdEstado());

        return respuesta;
    }
}
