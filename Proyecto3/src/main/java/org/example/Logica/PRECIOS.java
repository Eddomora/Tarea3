package org.example.Logica;
/**
 * Enum Precios define los PRECIOS que tendrá cada producto en el expendedor
 * Cada constante representa un producto.
 */

public enum PRECIOS {
    COCACOLA(900),
    SPRITE(800),
    FANTA(700),
    SNICKERS(1200),
    SUPER8(500);
    private final int precio;
    PRECIOS(int precio) {
        this.precio = precio;
    }
    public int getPrecio() {
        return precio;
    }
}
