package edu.altair.apicrm.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad que representa un curso del centro educativo.
 */
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(nullable = false, unique = true, length = 20)
    private String diminutivo;

    @Column(length = 255)
    private String descripcion;

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
     * @param diminutivo diminutivo del curso
     * @param descripcion descripción del curso
     * @param titulacion titulación a la que pertenece
     */
    public Curso(String diminutivo, String descripcion, Titulacion titulacion) {
        this.diminutivo = diminutivo;
        this.descripcion = descripcion;
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