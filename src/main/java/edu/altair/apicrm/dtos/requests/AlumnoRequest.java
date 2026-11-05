package edu.altair.apicrm.dtos.requests;

import java.time.LocalDate;

/**
 * DTO para recibir los datos de un alumno en las peticiones de la API.
 */
public class AlumnoRequest {

    private String nombre;
    private String apellidos;
    private String dni;
    private String numeroSs;
    private String emailPersonal;
    private String telefonoPersonal;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
    private String emailCentro;
    private Long idFamilia;

    /**
     * Constructor vacío de AlumnoRequest.
     */
    public AlumnoRequest() {
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
     * Obtiene el identificador de la familia.
     * @return identificador de la familia
     */
    public Long getIdFamilia() {
        return idFamilia;
    }

    /**
     * Establece el identificador de la familia.
     * @param idFamilia identificador de la familia
     */
    public void setIdFamilia(Long idFamilia) {
        this.idFamilia = idFamilia;
    }
}