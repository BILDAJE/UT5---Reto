
package edu.altair.apicrm.dtos.responses;

/**
 * DTO para devolver los datos de un estado en las respuestas de la API.
 */
public class EstadoResponse {

    private Long idEstado;
    private String nombre;
    private String descripcion;

    public EstadoResponse() {
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
