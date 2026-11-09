
package edu.altair.apicrm.dtos.requests;

/**
 * DTO para recibir los datos de una matrícula en las peticiones de la API.
 */
public class MatriculaRequest {

    private Long idAlumno;
    private Long idModulo;
    private Long idEstado;

    public MatriculaRequest() {
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }
}
