package edu.altair.apicrm.exceptions;

import java.time.LocalDateTime;

/**
 * Representa la información de un error producido en la API.
 * @author Ilde
 */
public class ErrorResponse {

    private LocalDateTime fecha;
    private int estado;
    private String error;
    private String mensaje;

    /**
     * Constructor vacío.
     */
    public ErrorResponse() {
    }

    /**
     * Constructor para crear una respuesta de error.
     * @param fecha fecha y hora del error
     * @param estado código HTTP
     * @param error descripción del estado HTTP
     * @param mensaje mensaje del error
     */
    public ErrorResponse(LocalDateTime fecha, int estado, String error, String mensaje) {
        this.fecha = fecha;
        this.estado = estado;
        this.error = error;
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}