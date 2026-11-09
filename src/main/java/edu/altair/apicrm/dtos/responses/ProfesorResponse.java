
package edu.altair.apicrm.dtos.responses;

import java.util.Set;

/**
 * DTO para devolver los datos de un profesor en las respuestas de la API.
 */
public class ProfesorResponse {

    private Long idProfesor;
    private String nombre;
    private String apellidos;
    private String dni;
    private String emailCentro;
    private String emailPersonal;
    private String telefonoPersonal;
    private Long idDepartamento;
    private Set<Long> idsModulos;

    public ProfesorResponse() {
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmailCentro() {
        return emailCentro;
    }

    public void setEmailCentro(String emailCentro) {
        this.emailCentro = emailCentro;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Set<Long> getIdsModulos() {
        return idsModulos;
    }

    public void setIdsModulos(Set<Long> idsModulos) {
        this.idsModulos = idsModulos;
    }
}
