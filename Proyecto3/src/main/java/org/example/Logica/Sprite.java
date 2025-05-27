package org.example.Logica;

public class Sprite extends Bebida{
    public Sprite(int numero) {
        super(numero);
    }
    @Override
    public String accion() {
        return super.accion() + "sprite";
    }
}

