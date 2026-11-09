
package edu.altair.apicrm.dtos.requests;

/**
 * DTO para recibir los datos de un curso en las peticiones de la API.
 */
public class CursoRequest {

    private String diminutivo;
    private String descripcion;
    private Long idTitulacion;

    public CursoRequest() {
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
