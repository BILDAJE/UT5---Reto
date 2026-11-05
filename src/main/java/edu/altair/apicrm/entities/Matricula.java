
package edu.altair.apicrm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad que representa la matrícula de un alumno en un módulo.
 * @author Ilde
 */
@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long idMatricula;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Matricula() {
    }

    /**
     * Constructor para crear una matrícula.
     *
     * @param alumno alumno asociado a la matrícula
     * @param modulo módulo asociado a la matrícula
     * @param estado estado de la matrícula
     */
    public Matricula(Alumno alumno, Modulo modulo, Estado estado) {
        this.alumno = alumno;
        this.modulo = modulo;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador de la matrícula.
     * @return identificador de la matrícula
     */
    public Long getIdMatricula() {
        return idMatricula;
    }

    /**
     * Establece el identificador de la matrícula.
     * @param idMatricula identificador de la matrícula
     */
    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    /**
     * Obtiene el alumno asociado a la matrícula.
     * @return alumno de la matrícula
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Establece el alumno asociado a la matrícula.
     * @param alumno alumno de la matrícula
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Obtiene el módulo asociado a la matrícula.
     * @return módulo de la matrícula
     */
    public Modulo getModulo() {
        return modulo;
    }

    /**
     * Establece el módulo asociado a la matrícula.
     * @param modulo módulo de la matrícula
     */
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    /**
     * Obtiene el estado de la matrícula.
     * @return estado de la matrícula
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la matrícula.
     * @param estado estado de la matrícula
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
