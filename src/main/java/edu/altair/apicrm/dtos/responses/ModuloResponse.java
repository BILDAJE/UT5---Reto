
package edu.altair.apicrm.dtos.responses;

import java.util.Set;

/**
 * DTO para devolver los datos de un módulo en las respuestas de la API.
 */
public class ModuloResponse {

    private Long idModulo;
    private String codigo;
    private String diminutivo;
    private String nombre;
    private String descripcion;
    private Integer horasSemanales;
    private Integer creditos;
    private Set<Long> idsProfesores;
    private Set<Long> idsCursos;

    public ModuloResponse() {
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
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
