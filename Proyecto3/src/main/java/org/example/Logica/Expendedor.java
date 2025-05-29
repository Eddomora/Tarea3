package org.example.Logica;
import org.example.Logica.Excepciones.*;

public class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    public static final int SNICKERS = 4;
    public static final int SUPER8 = 5;
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulces> snickers;
    private Deposito<Dulces> super8;
    private Deposito<Moneda> monVu;

    /**
     * El constructor del expendedor llena los depósitos con una cantidad dada de cada producto.
     *
     * @param cantidad la cantidad de cada producto que se desea cargar en los depósitos.
     */
    public Expendedor(int cantidad) {
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        fanta = new Deposito<Bebida>();
        snickers = new Deposito<Dulces>();
        super8 = new Deposito<Dulces>();
        monVu = new Deposito<Moneda>();

        for (int i = 0; i < cantidad; i++) {

            Bebida cocacola = new CocaCola(100 + i);
            coca.addCosa(cocacola);

            Bebida spriite = new Sprite(200 + i);
            sprite.addCosa(spriite);

            Bebida faanta = new Fanta(300 + i);
            fanta.addCosa(faanta);

            Dulces snicker = new Snickers(400 + i);
            snickers.addCosa(snicker);

            Dulces superocho = new Super8(500 + i);
            super8.addCosa(superocho);
        }
    }
    /**
     * Recibe una moneda y hace una compra según el producto seleccionado.
     * Valida si hay producto, si la moneda es válida y si el pago es suficiente.
     *
     * @param moneda la moneda ingresada para pagar.
     * @param select el número del producto seleccionado.
     * @param precio el precio del producto seleccionado.
     * @return el producto comprado (bebida o dulce).
     */

    public Producto comprarProducto(Moneda moneda, PRECIOS select, int precio) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        if (moneda == null) {
            throw new PagoIncorrectoException("No ingresaste una moneda");
        }
        monVu.addCosa(moneda);
        int valorMoneda = moneda.getValor();
        int vuelto_temporal = moneda.getValor() - precio;

        if (valorMoneda < precio) {
            monVu.getCosa();
            throw new PagoInsuficienteException("No te alcanza para comprar el producto");
        }

        Bebida b = null;
        Dulces d = null;
        switch (select) {
            case PRECIOS.COCACOLA:
                b = coca.getCosa();
                break;

            case PRECIOS.SPRITE:
                b = sprite.getCosa();
                break;

            case PRECIOS.FANTA:
                b = fanta.getCosa();
                break;

            case PRECIOS.SNICKERS:
                d = snickers.getCosa();
                break;

            case PRECIOS.SUPER8:
                d = super8.getCosa();
                break;

            default:
                monVu.getCosa();
                throw new NoHayProductoException("Número del producto equivocado");
        }
        if((b == null) && (d == null)){
            monVu.getCosa();
            throw new NoHayProductoException("No queda producto en el depósito");
        }
        else{
            for (int i = 0; i < vuelto_temporal; i += 100) {
                monVu.addCosa(new Moneda100(i+1));
            }
            if (b == null){
                monVu.getCosa();
                return d;
            }
            else{
                monVu.getCosa();
                return b;
            }
        }
    }
    /**
     * Entrega una moneda del depósito de vuelto.
     *
     * @return una {@code Moneda} de vuelto, o {@code null} si ya no quedan.
     */
    public Moneda getVuelto() {
        return monVu.getCosa();
    }
}