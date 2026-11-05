
package edu.altair.apicrm.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entidad que representa a un alumno del centro educativo.
 * @author Ilde
 */
@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "dni", unique = true, length = 9)
    private String dni;

    @Column(name = "numero_ss", unique = true, length = 12)
    private String numeroSs;

    @Column(name = "email_personal", length = 100)
    private String emailPersonal;

    @Column(name = "telefono_personal", length = 15)
    private String telefonoPersonal;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;

    @Column(name = "fecha_baja")
    private LocalDate fechaBaja;

    @Column(name = "email_centro", length = 100)
    private String emailCentro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_familia")
    private Familia familia;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private Set<Matricula> matriculas = new HashSet<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Alumno() {
    }

    /**
     * Constructor para crear un alumno.
     *
     * @param nombre nombre del alumno
     * @param apellidos apellidos del alumno
     * @param dni documento nacional de identidad
     * @param numeroSs número de la Seguridad Social
     * @param emailPersonal correo electrónico personal
     * @param telefonoPersonal teléfono personal
     * @param fechaAlta fecha de alta
     * @param fechaBaja fecha de baja
     * @param emailCentro correo electrónico del centro
     * @param familia familia asociada al alumno
     */
    public Alumno(String nombre, String apellidos, String dni,
            String numeroSs, String emailPersonal, String telefonoPersonal,
            LocalDate fechaAlta, LocalDate fechaBaja, String emailCentro,
            Familia familia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numeroSs = numeroSs;
        this.emailPersonal = emailPersonal;
        this.telefonoPersonal = telefonoPersonal;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.emailCentro = emailCentro;
        this.familia = familia;
    }

    /**
     * Obtiene el identificador del alumno.
     * @return identificador del alumno
     */
    public Long getIdAlumno() {
        return idAlumno;
    }

    /**
     * Establece el identificador del alumno.
     * @param idAlumno identificador del alumno
     */
    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    /**
     * Obtiene el nombre del alumno.
     * @return nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del alumno.
     * @param nombre nombre del alumno
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del alumno.
     * @return apellidos del alumno
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del alumno.
     * @param apellidos apellidos del alumno
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el DNI del alumno.
     * @return DNI del alumno
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del alumno.
     * @param dni DNI del alumno
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el número de la Seguridad Social.
     * @return número de la Seguridad Social
     */
    public String getNumeroSs() {
        return numeroSs;
    }

    /**
     * Establece el número de la Seguridad Social.
     * @param numeroSs número de la Seguridad Social
     */
    public void setNumeroSs(String numeroSs) {
        this.numeroSs = numeroSs;
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
     * Obtiene la fecha de alta.
     * @return fecha de alta
     */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Establece la fecha de alta.
     * @param fechaAlta fecha de alta
     */
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * Obtiene la fecha de baja.
     * @return fecha de baja
     */
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    /**
     * Establece la fecha de baja.
     * @param fechaBaja fecha de baja
     */
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
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
     * Obtiene la familia asociada al alumno.
     * @return familia del alumno
     */
    public Familia getFamilia() {
        return familia;
    }

    /**
     * Establece la familia asociada al alumno.
     * @param familia familia del alumno
     */
    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    /**
     * Obtiene las matrículas del alumno.
     * @return conjunto de matrículas
     */
    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    /**
     * Establece las matrículas del alumno.
     * @param matriculas conjunto de matrículas
     */
    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
