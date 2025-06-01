package org.example.Logica;
import org.example.Logica.Excepciones.*;

public class Comprador {
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, PRECIOS cualProducto, int precio, Expendedor exp) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException{
        this.sonido = null;
        this.vuelto = 0;
        /**
         * Crea un nuevo comprador que intenta comprar un producto del expendedor.
         *
         * @param m es la moneda insertada para comprar.
         * @param cualProducto producto para elegir,
         * @param precio precio del producto elegido.
         * @param exp el expendedor donde se realiza la compra.
         */

        if (cualProducto == PRECIOS.COCACOLA ||cualProducto == PRECIOS.SPRITE ||cualProducto == PRECIOS.FANTA) {
            Bebida compra = (Bebida) exp.comprarProducto(m, cualProducto, precio);
            if (compra != null) {
                this.sonido = compra.accion();
            }
        } else if (cualProducto == PRECIOS.SUPER8 || cualProducto == PRECIOS.SNICKERS) {
            Dulces compra = (Dulces) exp.comprarProducto(m, cualProducto, precio);
            if (compra != null) {
                this.sonido = compra.accion();
            }
        }
        //se obtiene el vuelto moneda a moneda hasta obtener el total.
        while (true) {
            Moneda aux = exp.getVuelto();
            if (aux == null) break;
            vuelto += aux.getValor();
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
    public int cuantoVuelto() {
        return vuelto;
    }

}
