package org.example.Logica;

public class Snickers extends Dulces{
    public Snickers(int numero) {
        super(numero);
    }

    @Override
    public String accion() {
        return super.accion() + "snickers";
    }
}
