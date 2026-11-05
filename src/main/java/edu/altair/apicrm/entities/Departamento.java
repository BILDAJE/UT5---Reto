
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
 * Entidad que representa un departamento del centro educativo.
 * @author Ilde
 */
@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private Set<Profesor> profesores = new HashSet<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Departamento() {
    }

    /**
     * Constructor para crear un departamento.
     * @param nombre nombre del departamento
     * @param descripcion descripción del departamento
     */
    public Departamento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador del departamento.
     * @return identificador del departamento
     */
    public Long getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * Establece el identificador del departamento.
     * @param idDepartamento identificador del departamento
     */
    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * Obtiene el nombre del departamento.
     * @return nombre del departamento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     * @param nombre nombre del departamento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del departamento.
     * @return descripción del departamento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del departamento.
     * @param descripcion descripción del departamento
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene los profesores pertenecientes al departamento.
     * @return conjunto de profesores
     */
    public Set<Profesor> getProfesores() {
        return profesores;
    }

    /**
     * Establece los profesores pertenecientes al departamento.
     * @param profesores conjunto de profesores
     */
    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }
}
