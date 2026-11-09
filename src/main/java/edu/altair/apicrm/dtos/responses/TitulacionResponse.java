
package edu.altair.apicrm.dtos.responses;

/**
 * DTO para devolver los datos de una titulación en las respuestas de la API.
 */
public class TitulacionResponse {

    private Long idTitulacion;
    private String codigo;
    private String diminutivo;
    private Integer horasTotales;

    public TitulacionResponse() {
    }

    public Long getIdTitulacion() {
        return idTitulacion;
    }

    public void setIdTitulacion(Long idTitulacion) {
        this.idTitulacion = idTitulacion;
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
