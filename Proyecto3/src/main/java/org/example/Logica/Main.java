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
    public static void main(String[] args){
        //esto es todo lo que debería tener el main
        Ventana v = new Ventana();
        
        /**
        List<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda500());
        monedas.add(new Moneda100());
        monedas.add(new Moneda1500());
        monedas.add(new Moneda1000());
        //Para ordenar en el main, deben usar el sort disponible en ArrayList. (pauta)
        Collections.sort(monedas);


        Expendedor exp = new Expendedor(1);
        Moneda m = null;
        Comprador c;

        // Cuando se trata de comprar sin moneda
      
        try {
            c = new Comprador(m, Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
            System.out.println(c.queCompraste() + ", tu vuelto es $" + c.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        }

       // Cuando no te alcanza para comprar el producto

        try{
            m = new Moneda500();
            c = new Comprador(m, Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
            System.out.println(c.queCompraste() + ", tu vuelto es $" + c.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        }

        // Cuando se intenta comprar con el depósito vacío
        try{
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
            System.out.println(c.queCompraste() + ", tu vuelto es $" + c.cuantoVuelto());

            Comprador d = new Comprador(m, Expendedor.COCA, PRECIOS.COCACOLA.getPrecio(), exp);
            System.out.println(d.queCompraste() + ", tu vuelto es $" + d.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        }
        // Cuando la compra es exitosa y el vuelto es 0
        try{
            m = new Moneda1000();
            c = new Comprador(m, Expendedor.SPRITE, PRECIOS.SPRITE.getPrecio(), exp);
            System.out.println(c.queCompraste() + ", tu vuelto es $" + c.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        }
        // Cuando la compra es exitosa y se compra con moneda de mayor valor que el producto
        try{
            m = new Moneda1500();
            c = new Comprador(m, Expendedor.SNICKERS, PRECIOS.SNICKERS.getPrecio(), exp);
            System.out.println(c.queCompraste() + ", tu vuelto es $" + c.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.err.println(e.getMessage());
        }
         **/
    }
}
