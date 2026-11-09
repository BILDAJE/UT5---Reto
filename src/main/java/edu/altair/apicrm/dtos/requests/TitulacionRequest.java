
package edu.altair.apicrm.dtos.requests;

/**
 * DTO para recibir los datos de una titulación en las peticiones de la API.
 */
public class TitulacionRequest {

    private String codigo;
    private String diminutivo;
    private Integer horasTotales;

    public TitulacionRequest() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public Integer getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(Integer horasTotales) {
        this.horasTotales = horasTotales;
    }
}
