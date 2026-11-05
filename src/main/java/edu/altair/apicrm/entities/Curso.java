
package edu.altair.apicrm.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

/**
 * Entidad que representa un curso del centro educativo.
 * @author Ilde
 */
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(name = "diminutivo", nullable = false, unique = true, length = 20)
    private String diminutivo;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "horas_semanales")
    private Integer horasSemanales;

    @Column(name = "creditos")
    private Integer creditos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_titulacion")
    private Titulacion titulacion;

    @ManyToMany(mappedBy = "cursos", fetch = FetchType.LAZY)
    private Set<Modulo> modulos = new HashSet<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Curso() {
    }

    /**
     * Constructor para crear un curso.
     *
     * @param diminutivo abreviatura del curso
     * @param descripcion descripción del curso
     * @param horasSemanales número de horas semanales
     * @param creditos número de créditos
     * @param titulacion titulación a la que pertenece
     */
    public Curso(String diminutivo, String descripcion, Integer horasSemanales,
            Integer creditos, Titulacion titulacion) {
        this.diminutivo = diminutivo;
        this.descripcion = descripcion;
        this.horasSemanales = horasSemanales;
        this.creditos = creditos;
        this.titulacion = titulacion;
    }

    /**
     * Obtiene el identificador del curso.
     * @return identificador del curso
     */
    public Long getIdCurso() {
        return idCurso;
    }

    /**
     * Establece el identificador del curso.
     * @param idCurso identificador del curso
     */
    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * Obtiene el diminutivo del curso.
     * @return diminutivo del curso
     */
    public String getDiminutivo() {
        return diminutivo;
    }

    /**
     * Establece el diminutivo del curso.
     * @param diminutivo diminutivo del curso
     */
    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    /**
     * Obtiene la descripción del curso.
     * @return descripción del curso
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del curso.
     * @param descripcion descripción del curso
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene las horas semanales del curso.
     * @return número de horas semanales
     */
    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    /**
     * Establece las horas semanales del curso.
     * @param horasSemanales número de horas semanales
     */
    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    /**
     * Obtiene los créditos del curso.
     * @return número de créditos
     */
    public Integer getCreditos() {
        return creditos;
    }

    /**
     * Establece los créditos del curso.
     * @param creditos número de créditos
     */
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    /**
     * Obtiene la titulación a la que pertenece el curso.
     * @return titulación del curso
     */
    public Titulacion getTitulacion() {
        return titulacion;
    }

    /**
     * Establece la titulación a la que pertenece el curso.
     * @param titulacion titulación del curso
     */
    public void setTitulacion(Titulacion titulacion) {
        this.titulacion = titulacion;
    }

    /**
     * Obtiene los módulos asociados al curso.
     * @return conjunto de módulos
     */
    public Set<Modulo> getModulos() {
        return modulos;
    }

    /**
     * Establece los módulos asociados al curso.
     * @param modulos conjunto de módulos
     */
    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
}
