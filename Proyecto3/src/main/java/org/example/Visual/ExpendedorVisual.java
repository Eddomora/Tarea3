package org.example.Visual;

import org.example.Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
    private JButton botonIngresar;
    private Expendedor expendedor = new Expendedor(10); //exp con stock 10 (prueba inicial)

    public static Deposito<Moneda> dep_vuelto;
    public static Moneda m;
    public static int dineroDisp;
    private static JLabel labelDinero;
    //private JLabel[] labelStock = new JLabel[5]; //numero de productors
    //private static final String[] nombreProductos = {"CocaCola", "Fanta", "Sprite", "Snickers", "Super8"};

    private String compra;
    JLabel productos;

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

        productos = new JLabel(imagenProducto("/"
                + cocaString
                + ".png"));


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
        labelDinero = new JLabel("DINERO: $" + dineroDisp);
        panelEstado.add(labelDinero);

        JButton botonTransferir = new JButton("INGRESAR MONEDA");
        botonTransferir.addActionListener(e -> transferirMonedas());
        panelEstado.add(botonTransferir);

        //labels para stock de cada producto
       /*for(int i = 0; i<labelStock.length; i++) {
            labelStock[i] = new JLabel(nombreProductos[i] + ": 10 unidades");
            panelEstado.add(labelStock[i]);
        } */

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        productos.setIcon(imagenProducto("/"
                + e.getActionCommand()
                + ".png"));
    }

    protected static ImageIcon imagenProducto(String path) {
        java.net.URL imgURL = ExpendedorVisual.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

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
                //labelDinero.setText("DINERO: $0");
                //depoDineroDisp(dep_vuelto);
                //actualizarStock();
                depoDineroDisp(dep_vuelto);
                int vuelto_total = dineroDisp;

                JOptionPane.showMessageDialog(this,
                        "Compraste: " + compra +
                                "\nVuelto: $" + dineroDisp);
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


    public void recogerProducto(){
        if (compra!= null) {
            JOptionPane.showMessageDialog(this, "Recogiste: " + compra + "\nToma tu vuelto: " + dineroDisp);
            //dineroDisp = 0;
            compra = null;

        } else {
            JOptionPane.showMessageDialog(this, "No hay nada para recoger");
        }
    }

   /* private void actualizarStock() {
        for (int i = 0; i < PRECIOS.values().length; i++) {
            PRECIOS producto = PRECIOS.values()[i];
            int stock = expendedor.getStock(producto);
            labelStock[i].setText(producto.name() +": "+ stock + " unidades.");
        }
    } */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(50, 50, 700, 600);
    }

    public void depoDineroDisp(Deposito<Moneda> dep){
        //solo contar, no extraer
        Moneda m;
        dineroDisp = 0;
        for (int i = 0; i < dep.size(); i++) {
            m = dep.getCosa();
            dineroDisp += m.getValor();
        }
    }

    private void transferirMonedas() {
        Deposito<Moneda> deposito = CompradorVisual.depositoComprador;
        if(deposito.size() == 0) {
            JOptionPane.showMessageDialog(this, "Primero saca alguna moneda.");
            return;
        }
        while (deposito.size() > 0) {
            Moneda m = deposito.getCosa();
            //CompradorVisual.ingresoMoneda(m);
            dep_vuelto.addCosa(m);
            dineroDisp += m.getValor();
        }

        actualizarDinero();
        PanelMonedas.actualizarDinero();
    }

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

    public static void actualizarDinero() {
        labelDinero.setText("DINERO: $" + dineroDisp);
    }
}