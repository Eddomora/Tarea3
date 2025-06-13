package org.example.Visual;

import org.example.Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

/**
 * Clase principal que representa la interfaz visual de la máquina expendedora.
 * Extiende JPanel e implementa ActionListener para manejar las interacciones del usuario.
 *
 * <p>Esta clase gestiona:</p>
 *
 *   La selección de productos mediante JRadioButton
 *   La visualización de productos con imágenes
 *   El manejo del dinero disponible (de monedero y depósito del expendedor)
 *   Las operaciones de compra y recogida de productos
 *   La transferencia de monedas entre depósitos
 *
 * @author Ignacio Soto
 */

public class ExpendedorVisual extends JPanel implements ActionListener {
    private JRadioButton cocaButton;
    private JRadioButton fantaButton;
    private JRadioButton spriteButton;
    private JRadioButton snickerButton;
    private JRadioButton super8Button;

    static String cocaString = "CocaCola";
    static String fantaString = "Fanta";
    static String spriteString = "Sprite";
    static String snickerString = "Snicker";
    static String super8String = "Super8";

    private JButton botonComprar;
    private JButton botonRecogerProd;
    private Expendedor expendedor = new Expendedor(10); //exp con stock 10 (prueba inicial)

    /**
     * Depósito estático que almacena las monedas de vuelto.
     * Accesible públicamente para operaciones desde otras clases.
     */

    public static Deposito<Moneda> dep_vuelto;
    public static Moneda m;
    public static int dineroDisp;
    private static JLabel labelDinero;

    //Label de stock
    private JLabel[] labelStock = new JLabel[5]; //numero de productors
    private static final String[] nombreProductos = {"CocaCola", "Fanta", "Sprite", "Snickers", "Super8"};

    private String compra;
    private JLabel productos;

    /**
     * Constructor de la clase ExpendedorVisual.
     * Inicializa todos los componentes de la interfaz gráfica de la máquina expendedora.
     * El constructor configura:
     *   Los botones de radio para selección de productos
     *   El grupo de botones para selección exclusiva
     *   Los paneles de disposición de componentes
     *   Los botones de acción (comprar, recoger, vuelto)
     *   La etiqueta de dinero disponible
     *   Los listeners para eventos de usuario
     */

    public ExpendedorVisual(){
        super(new BorderLayout());
        //setBackground(Color.ORANGE);
        dep_vuelto = new Deposito<Moneda>();

        cocaButton = new JRadioButton(cocaString);
        cocaButton.setMnemonic(KeyEvent.VK_B);
        cocaButton.setActionCommand(cocaString);
        cocaButton.setSelected(true);

        fantaButton = new JRadioButton(fantaString);
        fantaButton.setMnemonic(KeyEvent.VK_C);
        fantaButton.setActionCommand(fantaString);

        spriteButton = new JRadioButton(spriteString);
        spriteButton.setMnemonic(KeyEvent.VK_D);
        spriteButton.setActionCommand(spriteString);

        snickerButton = new JRadioButton(snickerString);
        snickerButton.setMnemonic(KeyEvent.VK_R);
        snickerButton.setActionCommand(snickerString);

        super8Button = new JRadioButton(super8String);
        super8Button.setMnemonic(KeyEvent.VK_P);
        super8Button.setActionCommand(super8String);

        ButtonGroup group = new ButtonGroup();
        group.add(cocaButton);
        group.add(fantaButton);
        group.add(spriteButton);
        group.add(snickerButton);
        group.add(super8Button);

        cocaButton.addActionListener(this);
        fantaButton.addActionListener(this);
        spriteButton.addActionListener(this);
        snickerButton.addActionListener(this);
        super8Button.addActionListener(this);

        productos = new JLabel("", JLabel.CENTER);
        productos.setPreferredSize(new Dimension(277, 222));

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(cocaButton);
        radioPanel.add(fantaButton);
        radioPanel.add(spriteButton);
        radioPanel.add(snickerButton);
        radioPanel.add(super8Button);

        //Creación de panel para ver el dinero disponible para comprar.
        JPanel panelEstado = new JPanel();
        panelEstado.setLayout(new BoxLayout(panelEstado, BoxLayout.Y_AXIS));
        panelEstado.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelDinero = new JLabel("DINERO: $" + dineroDisp);

        panelEstado.add(labelDinero);
        panelEstado.add(Box.createVerticalGlue());

        JButton botonTransferir = new JButton("INGRESAR MONEDA");
        botonTransferir.addActionListener(e -> transferirMonedas());
        botonTransferir.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelEstado.add(botonTransferir);

        panelEstado.add(Box.createVerticalGlue());

        //labels para stock de cada producto
        for(int i = 0; i<labelStock.length; i++) {
            labelStock[i] = new JLabel(nombreProductos[i] + ": 10 unidades");
            labelStock[i].setFont(new Font("Arial", Font.BOLD, 12));
            labelStock[i].setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            panelEstado.add(labelStock[i]);
        }

        JPanel panelInferior = new JPanel();

        botonComprar = new JButton("COMPRAR");
        botonComprar.addActionListener(e -> realizarCompra());

        botonRecogerProd = new JButton("RECOGER");
        botonRecogerProd.addActionListener(e -> recogerProducto());

        JButton botonSacarVuelto = new JButton("VUELTO");
        botonSacarVuelto.addActionListener(e -> sacarVuelto());

        panelInferior.add(botonSacarVuelto);
        panelInferior.add(botonRecogerProd);
        panelInferior.add(botonComprar);

        add(panelEstado, BorderLayout.LINE_END);
        add(radioPanel, BorderLayout.LINE_START);
        add(productos, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //posicion inicial, muestra imagen cocacola, su nombre y el precio
        cocaButton.setSelected(true);
        productos.setIcon(imagenProducto("/CocaCola.png"));
        productos.setText("Coca Cola $" + PRECIOS.COCACOLA.getPrecio());

        productos.setHorizontalTextPosition(JLabel.CENTER);
        productos.setVerticalTextPosition(JLabel.BOTTOM);
        productos.setFont(new Font("Arial", Font.BOLD, 16));//fuente del texto
        productos.setForeground(Color.WHITE);
    }

    /**
     * Actualiza la imagen del producto mostrada cuando se selecciona un botón de radio.
     * Se ejecuta automáticamente cuando el usuario hace clic en cualquiera de los
     * botones de radio de productos (Coca Cola, Fanta, Sprite, Snicker, Super8).
     *
     * @param e El evento de acción que contiene el comando del botón seleccionado
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String productoSeleccionado = e.getActionCommand();
        int precio = 0;
        //muestra el precio segun el producto
        switch (productoSeleccionado) {
            case "CocaCola":
                precio = PRECIOS.COCACOLA.getPrecio();
                break;
            case "Fanta":
                precio = PRECIOS.FANTA.getPrecio();
                break;
            case "Sprite":
                precio = PRECIOS.SPRITE.getPrecio();
                break;
            case "Snicker":
                precio = PRECIOS.SNICKERS.getPrecio();
                break;
            case "Super8":
                precio = PRECIOS.SUPER8.getPrecio();
                break;
        }
        productos.setIcon(imagenProducto("/" + productoSeleccionado + ".png"));
        productos.setText(productoSeleccionado + " - $" + precio);
    }
    /**
     * Carga y retorna un ImageIcon desde un recurso.
     * Método estático protegido que maneja la carga de imágenes de productos.
     *
     * @param path La ruta del archivo de imagen relativa a los recursos
     * @return ImageIcon con la imagen cargada, o null si no se encuentra el archivo
     *
     * @see ImageIcon
     */

    protected static ImageIcon imagenProducto(String path) {
        URL imgURL = ExpendedorVisual.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    /**
     * Realiza el proceso de compra del producto seleccionado.
     *
     * Este método:
     *   Identifica el producto seleccionado y su precio
     *   Crea un comprador con el dinero disponible
     *   Procesa la transacción a través del expendedor
     *   Actualiza el vuelto y el dinero disponible
     *   Muestra mensajes informativos al usuario
     *   Resetea el contador de dinero del comprador
     *
     *
     * Maneja las excepciones que puedan ocurrir durante la compra
     * y previene compras múltiples sin recoger el producto anterior.
     */

    public void realizarCompra() {
        PRECIOS tipo = null;
        int precio = 0;
        if (cocaButton.isSelected()) {
            tipo = PRECIOS.COCACOLA;
            precio = PRECIOS.COCACOLA.getPrecio();
        } else if (fantaButton.isSelected()) {
            tipo = PRECIOS.FANTA;
            precio = PRECIOS.FANTA.getPrecio();
        } else if (spriteButton.isSelected()) {
            tipo = PRECIOS.SPRITE;
            precio = PRECIOS.SPRITE.getPrecio();
        } else if (snickerButton.isSelected()) {
            tipo = PRECIOS.SNICKERS;
            precio = PRECIOS.SNICKERS.getPrecio();
        } else if (super8Button.isSelected()) {
            tipo = PRECIOS.SUPER8;
            precio = PRECIOS.SUPER8.getPrecio();
        }
        try {
            if (compra == null) {
                Comprador c = new Comprador(dep_vuelto, tipo, precio, expendedor);
                compra = c.queCompraste();
                dep_vuelto = c.cuantoVuelto();
                actualizarStock();
                depoDineroDisp();

                JOptionPane.showMessageDialog(this,
                        "Compraste: " + compra);
                PanelMonedas.totalDinero = 0;
                PanelMonedas.actualizarDinero();
            }
            else {
                JOptionPane.showMessageDialog(this,
                        "No puedes comprar, hay un producto por recoger");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error en la compra: " + e.getMessage());
        }
    }
    /**
     * Permite al usuario recoger el producto comprado.
     *
     * Este método verifica si hay un producto disponible para recoger
     * y procesa la recogida, mostrando un mensaje confirmatorio.
     * Después de recoger, resetea la variable de compra para permitir
     * nuevas transacciones.
     *
     * Si no hay productos por recoger, informa al usuario mediante
     * un mensaje de diálogo.
     */

    public void recogerProducto(){
        if (compra!= null) {

            JOptionPane.showMessageDialog(this, "Recogiste: " + compra);
      
            //dineroDisp = 0;
            compra = null;

        } else {
            JOptionPane.showMessageDialog(this, "No hay nada para recoger");
        }
    }


    /**
     * Dibuja el fondo gráfico de la máquina expendedora.
     * Sobrescribe el método paintComponent para personalizar la apariencia visual.
     *
     * @param g El contexto gráfico usado para pintar el componente
     *
     * @see JPanel#paintComponent(Graphics)
     */
   


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(50, 50, 700, 600);
    }

    /**
     * Actualiza la variable de dinero disponible basándose en el depósito de vuelto.
     * Calcula el valor total de todas las monedas en el depósito de vuelto
     * y actualiza la variable dineroDisp.
     */

    public void depoDineroDisp() {
        dineroDisp = dep_vuelto.calcularTotalValor();

    }

    /**
     * Transfiere todas las monedas del monedero del comprador a la máquina expendedora.
     * Simula  ser la ranura por la que pasa la moneda
     *
     * Este método:
     *
     *   Verifica que haya monedas disponibles en el monedero del comprador
     *   Transfiere todas las monedas al depósito de vuelto de la máquina
     *   Actualiza el dinero disponible y los contadores visuales
     *   Resetea el dinero total del comprador
     *
     *
     * Si no hay monedas disponibles, muestra un mensaje informativo.
     */


    private void transferirMonedas() {
        Deposito<Moneda> deposito = CompradorVisual.depositoComprador;
        if(deposito.size() == 0) {
            JOptionPane.showMessageDialog(this, "No hay monedas disponibles.");
            return;
        }
        while (deposito.size() > 0) {
            Moneda m = deposito.getCosa();
            //CompradorVisual.ingresoMoneda(m);
            dep_vuelto.addCosa(m);
            dineroDisp += m.getValor();
        }

        actualizarDinero();
        PanelMonedas.totalDinero = 0;
        PanelMonedas.actualizarDinero();
    }

/**
 * Permite al usuario retirar el vuelto de la máquina expendedora.
 */

 private void sacarVuelto() {
        if (dep_vuelto.size()==0) {
            JOptionPane.showMessageDialog(this, "No hay vuelto por retirar");
        }
        while (dep_vuelto.size() > 0) {
            Moneda m = dep_vuelto.getCosa();
            CompradorVisual.depositoComprador.addCosa(m);
            PanelMonedas.totalDinero += m.getValor();
        }
        dineroDisp = 0;
        actualizarDinero();
        PanelMonedas.actualizarDinero();

        JOptionPane.showMessageDialog(this, "Vuelto retirado con éxito.");
    }

/**
 * Permite al usuario retirar el vuelto de la máquina expendedora.
 */

 public static void actualizarDinero() {
        labelDinero.setText("DINERO: $" + dineroDisp);
    }
    private void actualizarStock() {
        for (int i = 0; i < PRECIOS.values().length; i++) {
            PRECIOS producto = PRECIOS.values()[i];
            int stock = expendedor.getStock(producto);
            labelStock[i].setText(producto.name() +": "+ stock + " unidades.");
        }
    }

}