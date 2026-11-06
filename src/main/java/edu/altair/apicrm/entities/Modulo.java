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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Entidad que representa un módulo del centro educativo.
 */
@Entity
@Table(name = "modulos")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private Long idModulo;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(nullable = false, unique = true, length = 20)
    private String diminutivo;

    @Column(length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(name = "horas_semanales")
    private Integer horasSemanales;

    @Column(name = "creditos")
    private Integer creditos;

    @ManyToMany(mappedBy = "modulos", fetch = FetchType.LAZY)
    private Set<Profesor> profesores = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "curso_modulo",
        joinColumns = @JoinColumn(name = "id_modulo"),
        inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private Set<Curso> cursos = new HashSet<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Modulo() {
    }

    /**
     * Constructor para crear un módulo.
     *
     * @param codigo código del módulo
     * @param diminutivo diminutivo del módulo
     * @param nombre nombre del módulo
     * @param descripcion descripción del módulo
     * @param horasSemanales número de horas semanales
     * @param creditos número de créditos
     */
    public Modulo(String codigo, String diminutivo, String nombre,
            String descripcion, Integer horasSemanales, Integer creditos) {
        this.codigo = codigo;
        this.diminutivo = diminutivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horasSemanales = horasSemanales;
        this.creditos = creditos;
    }

    /**
     * Obtiene el identificador del módulo.
     * @return identificador del módulo
     */
    public Long getIdModulo() {
        return idModulo;
    }

    /**
     * Establece el identificador del módulo.
     * @param idModulo identificador del módulo
     */
    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    /**
     * Obtiene el código del módulo.
     * @return código del módulo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del módulo.
     * @param codigo código del módulo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el diminutivo del módulo.
     * @return diminutivo del módulo
     */
    public String getDiminutivo() {
        return diminutivo;
    }

    /**
     * Establece el diminutivo del módulo.
     * @param diminutivo diminutivo del módulo
     */
    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    /**
     * Obtiene el nombre del módulo.
     * @return nombre del módulo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del módulo.
     * @param nombre nombre del módulo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del módulo.
     * @return descripción del módulo
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del módulo.
     * @param descripcion descripción del módulo
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene las horas semanales del módulo.
     * @return número de horas semanales
     */
    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    /**
     * Establece las horas semanales del módulo.
     * @param horasSemanales número de horas semanales
     */
    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    /**
     * Obtiene los créditos del módulo.
     * @return número de créditos
     */
    public Integer getCreditos() {
        return creditos;
    }

    /**
     * Establece los créditos del módulo.
     * @param creditos número de créditos
     */
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    /**
     * Obtiene los profesores que imparten el módulo.
     * @return conjunto de profesores
     */
    public Set<Profesor> getProfesores() {
        return profesores;
    }

    /**
     * Establece los profesores que imparten el módulo.
     * @param profesores conjunto de profesores
     */
    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    /**
     * Obtiene los cursos asociados al módulo.
     * @return conjunto de cursos
     */
    public Set<Curso> getCursos() {
        return cursos;
    }

    /**
     * Establece los cursos asociados al módulo.
     * @param cursos conjunto de cursos
     */
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}