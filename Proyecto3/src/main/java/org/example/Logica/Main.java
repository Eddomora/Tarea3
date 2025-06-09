package org.example.Logica;

import org.example.Logica.Excepciones.*;
import org.example.Visual.Ventana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Desde aquí probamos la interfaz gráfica, solo instanciamos una ventana
 *  Todo lo demás debe provenir de la ventana, como en un diagrama de árbol
 *
 * @author Ignacio Soto
 */
 public class Main {
    public static void main(String[] args) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda m1 = new Moneda1500(1);
        Moneda m2 = new Moneda1500(1);
        Moneda m3 = new Moneda1500(1);

        Deposito<Moneda> dm = new Deposito<>();
        dm.addCosa(m1);
        dm.addCosa(m2);
        dm.addCosa(m3);

        Expendedor e = new Expendedor(10);

        Comprador c = new Comprador(dm, PRECIOS.COCACOLA, PRECIOS.COCACOLA.getPrecio(), e);
        System.out.print(c.cuantoVuelto().calcularTotalValor());
    }
}
