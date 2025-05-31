package org.example.Logica;

public abstract class Moneda implements Comparable<Moneda> {
    private int serie;
    public Moneda(int serie) {
        this.serie = serie;
    }

    public int getSerie() {
        return serie;
    }
    /**
     * Devuelve el valor de la moneda.
     *
     * @return el valor entero de la moneda
     */
    public abstract int getValor();
    /**
     * Compara esta moneda con otra según su valor.
     *
     * @param otra es la otra moneda con la que se va a comparar
     * @return un número negativo si esta moneda es de menor valor,
     * cero si tienen el mismo valor,
     * un número positivo si esta moneda es de mayor valor
     */
    @Override
    public int compareTo(Moneda otra) {
        return Integer.compare(this.getValor(), otra.getValor());
    }
}

