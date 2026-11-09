
package edu.altair.apicrm.dtos.requests;

/**
 * DTO para recibir los datos de un estado en las peticiones de la API.
 */
public class EstadoRequest {

    private String nombre;
    private String descripcion;

    public EstadoRequest() {
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
