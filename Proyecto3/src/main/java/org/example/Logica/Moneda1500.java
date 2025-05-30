package org.example.Logica;
//Tuve que hacer esta clase como un archivo aparte para poder hacerlo público y poder usarlo en el Menú
//creo que habrá que hacer esto con todas las subclases de Moneda
public class Moneda1500 extends Moneda {
    public Moneda1500(int serie) {
        super(serie);
    }
    public int getValor() {
        return 1500;
    }
}
