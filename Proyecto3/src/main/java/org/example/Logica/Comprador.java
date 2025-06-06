package org.example.Logica;
import org.example.Logica.Excepciones.*;

public class Comprador {
    private String sonido;

    //volver vueltos un deposito de monedas

    private Deposito<Moneda> vueltos;

    public Comprador(Deposito<Moneda> monedero, PRECIOS cualProducto, int precio, Expendedor exp) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException{
        this.sonido = null;
        vueltos = new Deposito<Moneda>();

        exp.comprarProducto(monedero, cualProducto, precio);

        Producto comprado = exp.getProducto();
        if (comprado != null) {
            this.sonido = comprado.accion();
        }
        //se obtiene el vuelto moneda a moneda hasta obtener el total.
        Moneda moneda;
        while ((moneda = exp.getVuelto()) != null) {
            vueltos.addCosa(moneda);
        }
    }
    /**
     * Retorna el "sonido" o acción generada por el producto comprado.
     *
     * @return una cadena que representa la acción del producto, o {@code null} si no se compró.
     */
    public String queCompraste() {
        return sonido;
    }
    /**
     * Retorna el valor total del vuelto recibido tras la compra.
     *
     * @return el valor del vuelto.
     */
    public Deposito<Moneda> cuantoVuelto() {
        return vueltos;
    }

}
