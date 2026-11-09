
package edu.altair.apicrm.dtos.responses;

/**
 * DTO para devolver los datos de una matrícula en las respuestas de la API.
 */
public class MatriculaResponse {

    private Long idMatricula;
    private Long idAlumno;
    private Long idModulo;
    private Long idEstado;

    public MatriculaResponse() {
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
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
