package org.example.Logica.Excepciones;

public class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(String mensajeError){
        super(mensajeError);
    }
}