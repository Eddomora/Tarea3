package org.example.Logica;
/**
 * Enum Precios define los PRECIOS que tendrá cada producto en el expendedor
 * Cada constante representa un producto.
 */

public enum PRECIOS {
    COCACOLA(1200),
    SPRITE(1000),
    FANTA(1100),
    SNICKERS(1400),
    SUPER8(500);
    private final int precio;
    PRECIOS(int precio) {
        this.precio = precio;
    }
    public int getPrecio() {
        return precio;
    }
}
