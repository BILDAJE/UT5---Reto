
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

import edu.altair.apicrm.dtos.requests.CursoRequest;
import edu.altair.apicrm.dtos.responses.CursoResponse;
import edu.altair.apicrm.entities.Curso;
import edu.altair.apicrm.entities.Titulacion;
import edu.altair.apicrm.services.CursoService;
import edu.altair.apicrm.services.TitulacionService;

/**
 * Controlador REST para gestionar las operaciones de Curso.
 */
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;
    private final TitulacionService titulacionService;

    /**
     * Constructor del controlador de cursos.
     * @param cursoService servicio de cursos
     * @param titulacionService servicio de titulaciones
     */
    public CursoController(CursoService cursoService, TitulacionService titulacionService) {
        this.cursoService = cursoService;
        this.titulacionService = titulacionService;
    }

    /**
     * Obtiene todos los cursos registrados.
     * @return respuesta con la lista de cursos
     */
    @GetMapping
    public ResponseEntity<List<CursoResponse>> listarCursos() {

        List<Curso> cursos = cursoService.listarCursos();
        List<CursoResponse> respuestas = new ArrayList<>();

        for (Curso curso : cursos) {
            respuestas.add(convertirAResponse(curso));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Busca un curso por su identificador.
     * @param id identificador del curso
     * @return respuesta con el curso encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> buscarPorId(@PathVariable Long id) {

        Curso curso = cursoService.buscarPorId(id);

        return ResponseEntity.ok(convertirAResponse(curso));
    }

    /**
     * Guarda un nuevo curso.
     * @param cursoRequest datos del curso
     * @return respuesta con el curso creado
     */
    @PostMapping
    public ResponseEntity<CursoResponse> guardarCurso(
            @RequestBody CursoRequest cursoRequest) {

        Curso curso = convertirAEntidad(cursoRequest);
        Curso cursoGuardado = cursoService.guardarCurso(curso);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertirAResponse(cursoGuardado));
    }

    /**
     * Actualiza los datos de un curso.
     * @param id identificador del curso
     * @param cursoRequest nuevos datos del curso
     * @return respuesta con el curso actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> actualizarCurso(
            @PathVariable Long id,
            @RequestBody CursoRequest cursoRequest) {

        Curso curso = convertirAEntidad(cursoRequest);
        Curso cursoActualizado = cursoService.actualizarCurso(id, curso);

        return ResponseEntity.ok(convertirAResponse(cursoActualizado));
    }

    /**
     * Elimina un curso por su identificador.
     * @param id identificador del curso
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {

        cursoService.eliminarCurso(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Convierte los datos de una petición en una entidad Curso.
     * @param cursoRequest datos recibidos en la petición
     * @return entidad Curso
     */
    private Curso convertirAEntidad(CursoRequest cursoRequest) {

        Curso curso = new Curso();

        curso.setDiminutivo(cursoRequest.getDiminutivo());
        curso.setDescripcion(cursoRequest.getDescripcion());

        if (cursoRequest.getIdTitulacion() != null) {
            Titulacion titulacion =
                    titulacionService.buscarPorId(cursoRequest.getIdTitulacion());
            curso.setTitulacion(titulacion);
        }

        return curso;
    }

    /**
     * Convierte una entidad Curso en un DTO de respuesta.
     * @param curso entidad que se desea convertir
     * @return DTO con los datos del curso
     */
    private CursoResponse convertirAResponse(Curso curso) {

        CursoResponse respuesta = new CursoResponse();

        respuesta.setIdCurso(curso.getIdCurso());
        respuesta.setDiminutivo(curso.getDiminutivo());
        respuesta.setDescripcion(curso.getDescripcion());

        if (curso.getTitulacion() != null) {
            respuesta.setIdTitulacion(curso.getTitulacion().getIdTitulacion());
        }

        return respuesta;
    }
}
