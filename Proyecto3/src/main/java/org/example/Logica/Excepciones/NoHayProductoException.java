package org.example.Logica.Excepciones;

public class NoHayProductoException extends Exception{
    public NoHayProductoException(String mensajeError){
        super(mensajeError);
    }
}
