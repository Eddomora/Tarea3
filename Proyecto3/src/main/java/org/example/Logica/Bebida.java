package org.example.Logica;

public abstract class Bebida extends Producto{
    private int serie;

    public Bebida(int numero){
        super(numero);
    }
    public String accion(){return "Estás bebiendo: ";}
}