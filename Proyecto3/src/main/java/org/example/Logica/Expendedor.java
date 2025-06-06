package org.example.Logica;
import org.example.Logica.Excepciones.*;
import java.util.Random;


public class Expendedor {
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulces> snickers;
    private Deposito<Dulces> super8;
    private Deposito<Moneda> monedasAceptada;
    private Deposito<Moneda> monedasVuelto;
    private Producto producto;
    private Random random;


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

        monedasAceptada = new Deposito<Moneda>();
        monedasVuelto = new Deposito<>();

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

    public void comprarProducto(Moneda moneda, PRECIOS select, int precio) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        if (moneda == null) {
            throw new PagoIncorrectoException("No ingresaste una moneda");
        }

        int valorMoneda = moneda.getValor();
        if (valorMoneda < precio) {
            monedasVuelto.addCosa(moneda);
            throw new PagoInsuficienteException("No te alcanza para comprar el producto");
        }

        producto = null;
        switch (select) {
            case PRECIOS.COCACOLA:
                producto = coca.getCosa();
                break;

            case PRECIOS.SPRITE:
                producto = sprite.getCosa();
                break;

            case PRECIOS.FANTA:
                producto = fanta.getCosa();
                break;

            case PRECIOS.SNICKERS:
                producto = snickers.getCosa();
                break;

            case PRECIOS.SUPER8:
                producto = super8.getCosa();
                break;
        }

        if(producto == null){
            monedasVuelto.addCosa(moneda);
            throw new NoHayProductoException("No hay producto por retirar");
        }
        monedasAceptada.addCosa(moneda);

        //añadir el vuelto como un deposito
        random = new Random();
        int serie = random.nextInt(200);
        int vuelto = valorMoneda - precio;
        while (vuelto >= 1500) {
            monedasVuelto.addCosa(new Moneda1500(serie));
            vuelto -= 1500;

            int nuevo = random.nextInt(400);
            if (nuevo == serie){
                nuevo = random.nextInt(400);
            } else {
                serie = nuevo;
            }
        }
        while (vuelto >= 1000) {
            monedasVuelto.addCosa(new Moneda1000(serie));
            vuelto -= 1000;

            int nuevo = random.nextInt(400);
            if (nuevo == serie){
                nuevo = random.nextInt(400);
            } else {
                serie = nuevo;
            }
        }
        while (vuelto >= 500) {
            monedasVuelto.addCosa(new Moneda500(serie));
            vuelto -= 500;

            int nuevo = random.nextInt(400);
            if (nuevo == serie){
                nuevo = random.nextInt(400);
            } else {
                serie = nuevo;
            }
        }
        while (vuelto >= 100) {
            monedasVuelto.addCosa(new Moneda100(serie));
            vuelto -= 100;

            int nuevo = random.nextInt(400);
            if (nuevo == serie){
                nuevo = random.nextInt(400);
            } else {
                serie = nuevo;
            }
        }
    }

    //El metodo getProducto debes imaginarlo como meter la mano al deposito para sacar el producto comprado
    public Producto getProducto() {
        return producto;
    }

    /**
     * Entrega una moneda del depósito de vuelto.
     *
     * @return una {@code Moneda} de vuelto, o {@code null} si ya no quedan.
     */
    public Moneda getVuelto() {
        return monedasVuelto.getCosa();
    }

    public int getStock(PRECIOS tipo) {
        switch (tipo) {
            case COCACOLA: return coca.size();
            case FANTA: return fanta.size();
            case SPRITE: return sprite.size();
            case SNICKERS: return snickers.size();
            case SUPER8: return super8.size();
            default: return 0;
        }
    }
}