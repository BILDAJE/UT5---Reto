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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad que representa un profesor del centro educativo.
 */
@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String apellidos;

    @Column(unique = true, length = 9)
    private String dni;

    @Column(length = 150)
    private String emailCentro;

    @Column(length = 150)
    private String emailPersonal;

    @Column(length = 15)
    private String telefonoPersonal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamento;

    @ManyToMany
    @JoinTable(
        name = "profesor_modulo",
        joinColumns = @JoinColumn(name = "id_profesor"),
        inverseJoinColumns = @JoinColumn(name = "id_modulo")
    )
    private Set<Modulo> modulos = new HashSet<>();

    /**
     * Constructor vacío de Profesor.
     */
    public Profesor() {
    }

    /**
     * Constructor de Profesor con sus datos principales.
     *
     * @param nombre nombre del profesor
     * @param apellidos apellidos del profesor
     * @param dni DNI del profesor
     * @param emailCentro correo electrónico del centro
     * @param emailPersonal correo electrónico personal
     * @param telefonoPersonal teléfono personal
     * @param departamento departamento al que pertenece
     */
    public Profesor(String nombre, String apellidos, String dni,
            String emailCentro, String emailPersonal,
            String telefonoPersonal, Departamento departamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.emailCentro = emailCentro;
        this.emailPersonal = emailPersonal;
        this.telefonoPersonal = telefonoPersonal;
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
     * Obtiene los apellidos del profesor.
     * @return apellidos del profesor
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del profesor.
     * @param apellidos apellidos del profesor
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el DNI del profesor.
     * @return DNI del profesor
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del profesor.
     * @param dni DNI del profesor
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el correo electrónico del centro.
     * @return correo electrónico del centro
     */
    public String getEmailCentro() {
        return emailCentro;
    }

    /**
     * Establece el correo electrónico del centro.
     * @param emailCentro correo electrónico del centro
     */
    public void setEmailCentro(String emailCentro) {
        this.emailCentro = emailCentro;
    }

    /**
     * Obtiene el correo electrónico personal.
     * @return correo electrónico personal
     */
    public String getEmailPersonal() {
        return emailPersonal;
    }

    /**
     * Establece el correo electrónico personal.
     * @param emailPersonal correo electrónico personal
     */
    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    /**
     * Obtiene el teléfono personal.
     * @return teléfono personal
     */
    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    /**
     * Establece el teléfono personal.
     * @param telefonoPersonal teléfono personal
     */
    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
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