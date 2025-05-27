package org.example.Logica.Excepciones;

public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(String mensajeError) {
        super(mensajeError);
    }
}

