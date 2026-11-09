
package edu.altair.apicrm.dtos.requests;

import java.util.Set;

/**
 * DTO para recibir los datos de un módulo en las peticiones de la API.
 */
public class ModuloRequest {

    private String codigo;
    private String diminutivo;
    private String nombre;
    private String descripcion;
    private Integer horasSemanales;
    private Integer creditos;
    private Set<Long> idsProfesores;
    private Set<Long> idsCursos;

    public ModuloRequest() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
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

    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Set<Long> getIdsProfesores() {
        return idsProfesores;
    }

    public void setIdsProfesores(Set<Long> idsProfesores) {
        this.idsProfesores = idsProfesores;
    }

    public Set<Long> getIdsCursos() {
        return idsCursos;
    }

    public void setIdsCursos(Set<Long> idsCursos) {
        this.idsCursos = idsCursos;
    }
}
