package org.example.Logica;

public abstract class Moneda implements Comparable<Moneda> {
    public Moneda() {}

    public Moneda getSerie() {
        return this;
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

class Moneda1500 extends Moneda {
    public Moneda1500() {
        super();
    }
    public int getValor() {
        return 1500;
    }
}

class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
    }
    public int getValor() {
        return 1000;
    }
}

class Moneda500 extends Moneda {
    public Moneda500() {
        super();
    }
    public int getValor() {
        return 500;
    }
}

class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }
    public int getValor() {
        return 100;
    }
}
