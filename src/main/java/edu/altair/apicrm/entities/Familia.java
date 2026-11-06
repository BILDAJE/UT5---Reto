
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
 * Entidad que representa los datos familiares de los alumnos.
 * @author Ilde
 */
@Entity
@Table(name = "familias")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_familia")
    private Long idFamilia;

    @Column(name = "nombre_padre", length = 100)
    private String nombrePadre;

    @Column(name = "nombre_madre", length = 100)
    private String nombreMadre;

    @Column(name = "apellidos_padre", length = 150)
    private String apellidosPadre;

    @Column(name = "apellidos_madre", length = 150)
    private String apellidosMadre;

    @Column(name = "email_padre", length = 150)
    private String emailPadre;

    @Column(name = "email_madre", length = 150)
    private String emailMadre;

    @Column(name = "telefono_padre", length = 15)
    private String telefonoPadre;

    @Column(name = "telefono_madre", length = 15)
    private String telefonoMadre;

    @Column(name = "direccion_padre", length = 200)
    private String direccionPadre;

    @Column(name = "direccion_madre", length = 200)
    private String direccionMadre;

    @Column(name = "codigo_postal_padre", length = 10)
    private String codigoPostalPadre;

    @Column(name = "codigo_postal_madre", length = 10)
    private String codigoPostalMadre;

    @Column(name = "municipio_padre", length = 100)
    private String municipioPadre;

    @Column(name = "municipio_madre", length = 100)
    private String municipioMadre;

    @Column(name = "provincia_padre", length = 100)
    private String provinciaPadre;

    @Column(name = "provincia_madre", length = 100)
    private String provinciaMadre;

    @Column(name = "son_separados")
    private Boolean sonSeparados;

    @Column(name = "es_compartida")
    private Boolean esCompartida;

    @Column(name = "es_padre")
    private Boolean esPadre;

    @Column(name = "es_madre")
    private Boolean esMadre;

    @OneToMany(mappedBy = "familia", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos = new HashSet<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Familia() {
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

    /**
     * Obtiene el nombre del padre. 
     * @return nombre del padre
     */
    public String getNombrePadre() {
        return nombrePadre;
    }

    /**
     * Establece el nombre del padre. 
     * @param nombrePadre nombre del padre
     */
    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    /**
     * Obtiene el nombre de la madre. 
     * @return nombre de la madre
     */
    public String getNombreMadre() {
        return nombreMadre;
    }

    /**
     * Establece el nombre de la madre. 
     * @param nombreMadre nombre de la madre
     */
    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    /**
     * Obtiene los apellidos del padre. 
     * @return apellidos del padre
     */
    public String getApellidosPadre() {
        return apellidosPadre;
    }

    /**
     * Establece los apellidos del padre. 
     * @param apellidosPadre apellidos del padre
     */
    public void setApellidosPadre(String apellidosPadre) {
        this.apellidosPadre = apellidosPadre;
    }

    /**
     * Obtiene los apellidos de la madre. 
     * @return apellidos de la madre
     */
    public String getApellidosMadre() {
        return apellidosMadre;
    }

    /**
     * Establece los apellidos de la madre. 
     * @param apellidosMadre apellidos de la madre
     */
    public void setApellidosMadre(String apellidosMadre) {
        this.apellidosMadre = apellidosMadre;
    }

    /**
     * Obtiene el correo electrónico del padre. 
     * @return correo electrónico del padre
     */
    public String getEmailPadre() {
        return emailPadre;
    }

    /**
     * Establece el correo electrónico del padre.
     * @param emailPadre correo electrónico del padre
     */
    public void setEmailPadre(String emailPadre) {
        this.emailPadre = emailPadre;
    }

    /**
     * Obtiene el correo electrónico de la madre.
     * @return correo electrónico de la madre
     */
    public String getEmailMadre() {
        return emailMadre;
    }

    /**
     * Establece el correo electrónico de la madre.
     * @param emailMadre correo electrónico de la madre
     */
    public void setEmailMadre(String emailMadre) {
        this.emailMadre = emailMadre;
    }

    /**
     * Obtiene el teléfono del padre.
     * @return teléfono del padre
     */
    public String getTelefonoPadre() {
        return telefonoPadre;
    }

    /**
     * Establece el teléfono del padre.
     * @param telefonoPadre teléfono del padre
     */
    public void setTelefonoPadre(String telefonoPadre) {
        this.telefonoPadre = telefonoPadre;
    }

    /**
     * Obtiene el teléfono de la madre.
     * @return teléfono de la madre
     */
    public String getTelefonoMadre() {
        return telefonoMadre;
    }

    /**
     * Establece el teléfono de la madre.
     * @param telefonoMadre teléfono de la madre
     */
    public void setTelefonoMadre(String telefonoMadre) {
        this.telefonoMadre = telefonoMadre;
    }

    /**
     * Obtiene la dirección del padre.
     * @return dirección del padre
     */
    public String getDireccionPadre() {
        return direccionPadre;
    }

    /**
     * Establece la dirección del padre.
     * @param direccionPadre dirección del padre
     */
    public void setDireccionPadre(String direccionPadre) {
        this.direccionPadre = direccionPadre;
    }

    /**
     * Obtiene la dirección de la madre.
     * @return dirección de la madre
     */
    public String getDireccionMadre() {
        return direccionMadre;
    }

    /**
     * Establece la dirección de la madre.
     * @param direccionMadre dirección de la madre
     */
    public void setDireccionMadre(String direccionMadre) {
        this.direccionMadre = direccionMadre;
    }

    /**
     * Obtiene el código postal del padre. 
     * @return código postal del padre
     */
    public String getCodigoPostalPadre() {
        return codigoPostalPadre;
    }

    /**
     * Establece el código postal del padre.
     * @param codigoPostalPadre código postal del padre
     */
    public void setCodigoPostalPadre(String codigoPostalPadre) {
        this.codigoPostalPadre = codigoPostalPadre;
    }

    /**
     * Obtiene el código postal de la madre.
     * @return código postal de la madre
     */
    public String getCodigoPostalMadre() {
        return codigoPostalMadre;
    }

    /**
     * Establece el código postal de la madre.
     * @param codigoPostalMadre código postal de la madre
     */
    public void setCodigoPostalMadre(String codigoPostalMadre) {
        this.codigoPostalMadre = codigoPostalMadre;
    }

    /**
     * Obtiene el municipio del padre.
     * @return municipio del padre
     */
    public String getMunicipioPadre() {
        return municipioPadre;
    }

    /**
     * Establece el municipio del padre.
     * @param municipioPadre municipio del padre
     */
    public void setMunicipioPadre(String municipioPadre) {
        this.municipioPadre = municipioPadre;
    }

    /**
     * Obtiene el municipio de la madre.
     * @return municipio de la madre
     */
    public String getMunicipioMadre() {
        return municipioMadre;
    }

    /**
     * Establece el municipio de la madre.
     * @param municipioMadre municipio de la madre
     */
    public void setMunicipioMadre(String municipioMadre) {
        this.municipioMadre = municipioMadre;
    }

    /**
     * Obtiene la provincia del padre.
     * @return provincia del padre
     */
    public String getProvinciaPadre() {
        return provinciaPadre;
    }

    /**
     * Establece la provincia del padre.
     * @param provinciaPadre provincia del padre
     */
    public void setProvinciaPadre(String provinciaPadre) {
        this.provinciaPadre = provinciaPadre;
    }

    /**
     * Obtiene la provincia de la madre.
     * @return provincia de la madre
     */
    public String getProvinciaMadre() {
        return provinciaMadre;
    }

    /**
     * Establece la provincia de la madre.
     * @param provinciaMadre provincia de la madre
     */
    public void setProvinciaMadre(String provinciaMadre) {
        this.provinciaMadre = provinciaMadre;
    }

    /**
     * Comprueba si los padres están separados.
     * @return true si están separados; false en caso contrario
     */
    public Boolean getSonSeparados() {
        return sonSeparados;
    }

    /**
     * Establece si los padres están separados.
     * @param sonSeparados indica si los padres están separados
     */
    public void setSonSeparados(Boolean sonSeparados) {
        this.sonSeparados = sonSeparados;
    }

    /**
     * Comprueba si la familia es compartida.
     * @return true si es compartida; false en caso contrario
     */
    public Boolean getEsCompartida() {
        return esCompartida;
    }

    /**
     * Establece si la familia es compartida.
     * @param esCompartida indica si la familia es compartida
     */
    public void setEsCompartida(Boolean esCompartida) {
        this.esCompartida = esCompartida;
    }

    /**
     * Comprueba si existe información del padre.
     * @return true si existe información del padre
     */
    public Boolean getEsPadre() {
        return esPadre;
    }

    /**
     * Establece si existe información del padre.

     * @param esPadre indica si existe información del padre
     */
    public void setEsPadre(Boolean esPadre) {
        this.esPadre = esPadre;
    }

    /**
     * Comprueba si existe información de la madre.
     * @return true si existe información de la madre
     */
    public Boolean getEsMadre() {
        return esMadre;
    }

    /**
     * Establece si existe información de la madre.
     * @param esMadre indica si existe información de la madre
     */
    public void setEsMadre(Boolean esMadre) {
        this.esMadre = esMadre;
    }

    /**
     * Obtiene los alumnos asociados a la familia.
     * @return conjunto de alumnos
     */
    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * Establece los alumnos asociados a la familia.
     * @param alumnos conjunto de alumnos
     */
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
