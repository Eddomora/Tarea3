package org.example.Logica;

public abstract class Dulces extends Producto {
    private int serie;

    public Dulces(int numero){
        super(numero);
    }

    public String accion(){return "Estás comiendo: ";}
}