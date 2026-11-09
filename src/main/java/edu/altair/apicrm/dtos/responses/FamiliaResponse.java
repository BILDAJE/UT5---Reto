
package edu.altair.apicrm.dtos.responses;

/**
 * DTO para devolver los datos de una familia en las respuestas de la API.
 */
public class FamiliaResponse {

    private Long idFamilia;
    private String nombrePadre;
    private String nombreMadre;
    private String apellidosPadre;
    private String apellidosMadre;
    private String emailPadre;
    private String emailMadre;
    private String telefonoPadre;
    private String telefonoMadre;
    private String direccionPadre;
    private String direccionMadre;
    private String codigoPostalPadre;
    private String codigoPostalMadre;
    private String municipioPadre;
    private String municipioMadre;
    private String provinciaPadre;
    private String provinciaMadre;
    private Boolean sonSeparados;
    private Boolean esCompartida;
    private Boolean esPadre;
    private Boolean esMadre;

    public FamiliaResponse() {
    }

    public Long getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Long idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getApellidosPadre() {
        return apellidosPadre;
    }

    public void setApellidosPadre(String apellidosPadre) {
        this.apellidosPadre = apellidosPadre;
    }

    public String getApellidosMadre() {
        return apellidosMadre;
    }

    public void setApellidosMadre(String apellidosMadre) {
        this.apellidosMadre = apellidosMadre;
    }

    public String getEmailPadre() {
        return emailPadre;
    }

    public void setEmailPadre(String emailPadre) {
        this.emailPadre = emailPadre;
    }

    public String getEmailMadre() {
        return emailMadre;
    }

    public void setEmailMadre(String emailMadre) {
        this.emailMadre = emailMadre;
    }

    public String getTelefonoPadre() {
        return telefonoPadre;
    }

    public void setTelefonoPadre(String telefonoPadre) {
        this.telefonoPadre = telefonoPadre;
    }

    public String getTelefonoMadre() {
        return telefonoMadre;
    }

    public void setTelefonoMadre(String telefonoMadre) {
        this.telefonoMadre = telefonoMadre;
    }

    public String getDireccionPadre() {
        return direccionPadre;
    }

    public void setDireccionPadre(String direccionPadre) {
        this.direccionPadre = direccionPadre;
    }

    public String getDireccionMadre() {
        return direccionMadre;
    }

    public void setDireccionMadre(String direccionMadre) {
        this.direccionMadre = direccionMadre;
    }

    public String getCodigoPostalPadre() {
        return codigoPostalPadre;
    }

    public void setCodigoPostalPadre(String codigoPostalPadre) {
        this.codigoPostalPadre = codigoPostalPadre;
    }

    public String getCodigoPostalMadre() {
        return codigoPostalMadre;
    }

    public void setCodigoPostalMadre(String codigoPostalMadre) {
        this.codigoPostalMadre = codigoPostalMadre;
    }

    public String getMunicipioPadre() {
        return municipioPadre;
    }

    public void setMunicipioPadre(String municipioPadre) {
        this.municipioPadre = municipioPadre;
    }

    public String getMunicipioMadre() {
        return municipioMadre;
    }

    public void setMunicipioMadre(String municipioMadre) {
        this.municipioMadre = municipioMadre;
    }

    public String getProvinciaPadre() {
        return provinciaPadre;
    }

    public void setProvinciaPadre(String provinciaPadre) {
        this.provinciaPadre = provinciaPadre;
    }

    public String getProvinciaMadre() {
        return provinciaMadre;
    }

    public void setProvinciaMadre(String provinciaMadre) {
        this.provinciaMadre = provinciaMadre;
    }

    public Boolean getSonSeparados() {
        return sonSeparados;
    }

    public void setSonSeparados(Boolean sonSeparados) {
        this.sonSeparados = sonSeparados;
    }

    public Boolean getEsCompartida() {
        return esCompartida;
    }

    public void setEsCompartida(Boolean esCompartida) {
        this.esCompartida = esCompartida;
    }

    public Boolean getEsPadre() {
        return esPadre;
    }

    public void setEsPadre(Boolean esPadre) {
        this.esPadre = esPadre;
    }

    public Boolean getEsMadre() {
        return esMadre;
    }

    public void setEsMadre(Boolean esMadre) {
        this.esMadre = esMadre;
    }
}
