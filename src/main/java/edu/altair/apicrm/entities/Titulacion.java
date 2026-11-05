
package edu.altair.apicrm.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entidad que representa una titulación del centro educativo.
 * @author Ilde
 */
@Entity
@Table(name = "titulaciones")
public class Titulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titulacion")
    private Long idTitulacion;

    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(name = "diminutivo", nullable = false, unique = true, length = 20)
    private String diminutivo;

    @Column(name = "horas_totales")
    private Integer horasTotales;

    @OneToMany(mappedBy = "titulacion", fetch = FetchType.LAZY)
    private Set<Curso> cursos = new HashSet<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Titulacion() {
    }

    /**
     * Constructor para crear una titulación.
     * @param codigo código de la titulación
     * @param diminutivo abreviatura de la titulación
     * @param horasTotales número total de horas
     */
    public Titulacion(String codigo, String diminutivo, Integer horasTotales) {
        this.codigo = codigo;
        this.diminutivo = diminutivo;
        this.horasTotales = horasTotales;
    }

    /**
     * Obtiene el identificador de la titulación.
     * @return identificador de la titulación
     */
    public Long getIdTitulacion() {
        return idTitulacion;
    }

    /**
     * Establece el identificador de la titulación.
     * @param idTitulacion identificador de la titulación
     */
    public void setIdTitulacion(Long idTitulacion) {
        this.idTitulacion = idTitulacion;
    }

    /**
     * Obtiene el código de la titulación.
     * @return código de la titulación
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de la titulación.
     * @param codigo código de la titulación
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el diminutivo de la titulación.
     * @return diminutivo de la titulación
     */
    public String getDiminutivo() {
        return diminutivo;
    }

    /**
     * Establece el diminutivo de la titulación.
     * @param diminutivo diminutivo de la titulación
     */
    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    /**
     * Obtiene las horas totales de la titulación.
     * @return número total de horas
     */
    public Integer getHorasTotales() {
        return horasTotales;
    }

    /**
     * Establece las horas totales de la titulación.
     * @param horasTotales número total de horas
     */
    public void setHorasTotales(Integer horasTotales) {
        this.horasTotales = horasTotales;
    }

    /**
     * Obtiene los cursos asociados a la titulación.
     * @return conjunto de cursos
     */
    public Set<Curso> getCursos() {
        return cursos;
    }

    /**
     * Establece los cursos asociados a la titulación.
     * @param cursos conjunto de cursos
     */
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}
