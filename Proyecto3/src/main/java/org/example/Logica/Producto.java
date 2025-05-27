package org.example.Logica;

public abstract class Producto {
    private int serie;

    public Producto(int numero){
        serie = numero;
    }

    public int getSerie() {
        return serie;
    }
    /**
     * El Metodo abstracto representa una acción que puede hacer un producto al consumirlo.
     * Por ejemplo, una bebida puede hacer un sonido al beberla.
     *
     * @return una cadena que representa la acción realizada
     */
    public abstract String accion();
}
