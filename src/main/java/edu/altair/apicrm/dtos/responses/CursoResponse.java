
package edu.altair.apicrm.dtos.responses;

/**
 * DTO para devolver los datos de un curso en las respuestas de la API.
 */
public class CursoResponse {

    private Long idCurso;
    private String diminutivo;
    private String descripcion;
    private Long idTitulacion;

    public CursoResponse() {
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdTitulacion() {
        return idTitulacion;
    }

    public void setIdTitulacion(Long idTitulacion) {
        this.idTitulacion = idTitulacion;
    }
}
