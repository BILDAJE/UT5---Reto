package edu.altair.apicrm.exceptions;

/**
 * Excepción que se lanza cuando no se encuentra un recurso solicitado.
 * @author Ilde
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor de la excepción.
     * @param mensaje descripción del error
     */
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}