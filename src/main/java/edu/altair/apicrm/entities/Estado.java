
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
 * Entidad que representa un estado de matrícula.
 * @author Ilde
 */
@Entity
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private Set<Matricula> matriculas = new HashSet<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Estado() {
    }

    /**
     * Constructor para crear un estado.
     * @param nombre nombre del estado
     * @param descripcion descripción del estado
     */
    public Estado(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador del estado.
     * @return identificador del estado
     */
    public Long getIdEstado() {
        return idEstado;
    }

    /**
     * Establece el identificador del estado.
     * @param idEstado identificador del estado
     */
    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * Obtiene el nombre del estado.
     * @return nombre del estado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estado.
     * @param nombre nombre del estado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del estado.
     * @return descripción del estado
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del estado.
     * @param descripcion descripción del estado
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene las matrículas asociadas al estado.
     * @return conjunto de matrículas
     */
    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    /**
     * Establece las matrículas asociadas al estado.
     * @param matriculas conjunto de matrículas
     */
    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
