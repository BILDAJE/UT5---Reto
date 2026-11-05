
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entidad que representa un módulo formativo del centro educativo.
 * @author Ilde
 */
@Entity
@Table(name = "modulos")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private Long idModulo;

    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "modulos_cursos",
        joinColumns = @JoinColumn(name = "id_modulo"),
        inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private Set<Curso> cursos = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "imparte",
        joinColumns = @JoinColumn(name = "id_modulo"),
        inverseJoinColumns = @JoinColumn(name = "id_profesor")
    )
    private Set<Profesor> profesores = new HashSet<>();

    @OneToMany(mappedBy = "modulo", fetch = FetchType.LAZY)
    private Set<Matricula> matriculas = new HashSet<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Modulo() {
    }

    /**
     * Constructor para crear un módulo.
     * @param codigo código identificativo del módulo
     * @param nombre nombre del módulo
     */
    public Modulo(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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
     * Obtiene las matrículas asociadas al módulo.
     * @return conjunto de matrículas
     */
    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    /**
     * Establece las matrículas asociadas al módulo.
     * @param matriculas conjunto de matrículas
     */
    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
