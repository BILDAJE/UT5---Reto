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
 */
@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 15)
    private String telefono;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private Set<Profesor> profesores = new HashSet<>();

    /**
     * Constructor vacío de Departamento.
     */
    public Departamento() {
    }

    /**
     * Constructor de Departamento con sus datos principales.
     *
     * @param codigo código del departamento
     * @param nombre nombre del departamento
     * @param descripcion descripción del departamento
     * @param telefono teléfono del departamento
     */
    public Departamento(String codigo, String nombre, String descripcion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
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
     * Obtiene el código del departamento.
     * @return código del departamento
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del departamento.
     * @param codigo código del departamento
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * Obtiene el teléfono del departamento.
     * @return teléfono del departamento
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del departamento.
     * @param telefono teléfono del departamento
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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