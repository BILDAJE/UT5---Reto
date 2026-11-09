
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

import edu.altair.apicrm.dtos.requests.ModuloRequest;
import edu.altair.apicrm.dtos.responses.ModuloResponse;
import edu.altair.apicrm.entities.Curso;
import edu.altair.apicrm.entities.Modulo;
import edu.altair.apicrm.entities.Profesor;
import edu.altair.apicrm.services.CursoService;
import edu.altair.apicrm.services.ModuloService;
import edu.altair.apicrm.services.ProfesorService;

/**
 * Controlador REST para gestionar las operaciones de Modulo.
 */
@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    private final ModuloService moduloService;
    private final ProfesorService profesorService;
    private final CursoService cursoService;

    /**
     * Constructor del controlador de módulos.
     * @param moduloService servicio de módulos
     * @param profesorService servicio de profesores
     * @param cursoService servicio de cursos
     */
    public ModuloController(ModuloService moduloService,
            ProfesorService profesorService, CursoService cursoService) {

        this.moduloService = moduloService;
        this.profesorService = profesorService;
        this.cursoService = cursoService;
    }

    /**
     * Obtiene todos los módulos registrados.
     * @return respuesta con la lista de módulos
     */
    @GetMapping
    public ResponseEntity<List<ModuloResponse>> listarModulos() {

        List<Modulo> modulos = moduloService.listarModulos();
        List<ModuloResponse> respuestas = new ArrayList<>();

        for (Modulo modulo : modulos) {
            respuestas.add(convertirAResponse(modulo));
        }

        return ResponseEntity.ok(respuestas);
    }

    /**
     * Busca un módulo por su identificador.
     * @param id identificador del módulo
     * @return respuesta con el módulo encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<ModuloResponse> buscarPorId(@PathVariable Long id) {

        Modulo modulo = moduloService.buscarPorId(id);

        return ResponseEntity.ok(convertirAResponse(modulo));
    }

    /**
     * Guarda un nuevo módulo.
     * @param moduloRequest datos del módulo
     * @return respuesta con el módulo creado
     */
    @PostMapping
    public ResponseEntity<ModuloResponse> guardarModulo(
            @RequestBody ModuloRequest moduloRequest) {

        Modulo modulo = convertirAEntidad(moduloRequest);
        Modulo moduloGuardado = moduloService.guardarModulo(modulo);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertirAResponse(moduloGuardado));
    }

    /**
     * Actualiza los datos de un módulo.
     * @param id identificador del módulo
     * @param moduloRequest nuevos datos del módulo
     * @return respuesta con el módulo actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<ModuloResponse> actualizarModulo(
            @PathVariable Long id,
            @RequestBody ModuloRequest moduloRequest) {

        Modulo modulo = convertirAEntidad(moduloRequest);
        Modulo moduloActualizado = moduloService.actualizarModulo(id, modulo);

        return ResponseEntity.ok(convertirAResponse(moduloActualizado));
    }

    /**
     * Elimina un módulo por su identificador.
     * @param id identificador del módulo
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarModulo(@PathVariable Long id) {

        moduloService.eliminarModulo(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Convierte los datos de una petición en una entidad Modulo.
     * @param moduloRequest datos recibidos en la petición
     * @return entidad Modulo
     */
    private Modulo convertirAEntidad(ModuloRequest moduloRequest) {

        Modulo modulo = new Modulo();

        modulo.setCodigo(moduloRequest.getCodigo());
        modulo.setDiminutivo(moduloRequest.getDiminutivo());
        modulo.setNombre(moduloRequest.getNombre());
        modulo.setDescripcion(moduloRequest.getDescripcion());
        modulo.setHorasSemanales(moduloRequest.getHorasSemanales());
        modulo.setCreditos(moduloRequest.getCreditos());

        if (moduloRequest.getIdsProfesores() != null) {
            Set<Profesor> profesores = new HashSet<>();

            for (Long idProfesor : moduloRequest.getIdsProfesores()) {
                profesores.add(profesorService.buscarPorId(idProfesor));
            }

            modulo.setProfesores(profesores);
        }

        if (moduloRequest.getIdsCursos() != null) {
            Set<Curso> cursos = new HashSet<>();

            for (Long idCurso : moduloRequest.getIdsCursos()) {
                cursos.add(cursoService.buscarPorId(idCurso));
            }

            modulo.setCursos(cursos);
        }

        return modulo;
    }

    /**
     * Convierte una entidad Modulo en un DTO de respuesta.
     * @param modulo entidad que se desea convertir
     * @return DTO con los datos del módulo
     */
    private ModuloResponse convertirAResponse(Modulo modulo) {

        ModuloResponse respuesta = new ModuloResponse();

        respuesta.setIdModulo(modulo.getIdModulo());
        respuesta.setCodigo(modulo.getCodigo());
        respuesta.setDiminutivo(modulo.getDiminutivo());
        respuesta.setNombre(modulo.getNombre());
        respuesta.setDescripcion(modulo.getDescripcion());
        respuesta.setHorasSemanales(modulo.getHorasSemanales());
        respuesta.setCreditos(modulo.getCreditos());

        Set<Long> idsProfesores = new HashSet<>();

        if (modulo.getProfesores() != null) {
            for (Profesor profesor : modulo.getProfesores()) {
                idsProfesores.add(profesor.getIdProfesor());
            }
        }

        respuesta.setIdsProfesores(idsProfesores);

        Set<Long> idsCursos = new HashSet<>();

        if (modulo.getCursos() != null) {
            for (Curso curso : modulo.getCursos()) {
                idsCursos.add(curso.getIdCurso());
            }
        }

        respuesta.setIdsCursos(idsCursos);

        return respuesta;
    }
}
