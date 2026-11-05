
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
 * Entidad que representa a un profesor del centro educativo.
 * @author Ilde
 */
@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamento;

    @ManyToMany(mappedBy = "profesores", fetch = FetchType.LAZY)
    private Set<Modulo> modulos = new HashSet<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Profesor() {
    }

    /**
     * Constructor para crear un profesor.
     * @param nombre nombre del profesor
     * @param departamento departamento al que pertenece
     */
    public Profesor(String nombre, Departamento departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    /**
     * Obtiene el identificador del profesor.
     * @return identificador del profesor
     */
    public Long getIdProfesor() {
        return idProfesor;
    }

    /**
     * Establece el identificador del profesor.
     * @param idProfesor identificador del profesor
     */
    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    /**
     * Obtiene el nombre del profesor.
     * @return nombre del profesor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del profesor.
     * @param nombre nombre del profesor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el departamento del profesor.
     * @return departamento del profesor
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento del profesor.
     * @param departamento departamento del profesor
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene los módulos impartidos por el profesor.
     * @return conjunto de módulos
     */
    public Set<Modulo> getModulos() {
        return modulos;
    }

    /**
     * Establece los módulos impartidos por el profesor.
     * @param modulos conjunto de módulos
     */
    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
}
