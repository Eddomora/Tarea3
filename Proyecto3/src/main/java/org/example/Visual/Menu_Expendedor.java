package org.example.Visual;

import org.example.Logica.CocaCola;
import org.example.Logica.Expendedor;
import org.example.Logica.Moneda;
import org.example.Logica.PRECIOS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu_Expendedor extends JPanel implements ActionListener {

    private JRadioButton cocaButton;
    private JRadioButton fantaButton;
    private JRadioButton spriteButton;
    private JRadioButton snickerButton;
    private JRadioButton super8Button;

    private JButton boton1;
    private JButton boton2;
    private JButton botonComprar;
    private Expendedor expendedor = new Expendedor(10); //exp con stock 10 (prueba inicial)
    // private Moneda moneda = new Moneda(99);

    static String cocaString = "CocaCola";
    static String fantaString = "Fanta";
    static String spriteString = "Sprite";
    static String snickerString = "Snicker";
    static String super8String = "Super8";

    JLabel picture;

    public Menu_Expendedor() {
        super(new BorderLayout());

//        super();
//        this.setLayout(new FlowLayout()); //esto crea automaticamente el orden parece
//
//        boton1 = new JButton("Derecho"); //nombre del boton
//        boton1.setMnemonic(KeyEvent.VK_D); //Esta parte hace que al apretar alt+d se presiona sin necesidad del click
//        boton1.setActionCommand("enable"); //
//
//        boton2 = new JButton("Izquierdo");
//        boton2.setMnemonic(KeyEvent.VK_A); //Lo mismo pero con a
//        boton2.setActionCommand("disable");
//
//        boton1.setToolTipText("Click para habilitar el Izquierdo.");
//        boton2.setToolTipText("Click para habilitar el Derecho.");
//
//        boton1.setEnabled(true);
//        boton2.setEnabled(false);
//
//
//        boton1.addActionListener(this);
//        boton2.addActionListener(this);
//
//
//        add(boton1);
//        add(boton2);

        //Tablero de opciones sacado de RadioButtonDemo.java en examples Swing java
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

        picture = new JLabel(createImageIcon("/"
                + cocaString
                + ".gif"));


        picture.setPreferredSize(new Dimension(277, 222));

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(cocaButton);
        radioPanel.add(fantaButton);
        radioPanel.add(spriteButton);
        radioPanel.add(snickerButton);
        radioPanel.add(super8Button);

        botonComprar = new JButton("COMPRAR");
        botonComprar.addActionListener(e -> realizarCompra());

        add(radioPanel, BorderLayout.LINE_START);
        add(picture, BorderLayout.CENTER);
        add(botonComprar, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        picture.setIcon(createImageIcon("/"
                + e.getActionCommand()
                + ".gif"));
    }
    //cambia de estado entre poder apretar a no poder apretar
//    public void actionPerformed(ActionEvent e) {
//        if ("disable".equals(e.getActionCommand())) {
//            boton1.setEnabled(true);
//            boton2.setEnabled(false);
//
//        } else {
//            boton1.setEnabled(false);
//            boton2.setEnabled(true);
//        }
//    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Menu_Expendedor.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    public void realizarCompra() {
        PRECIOS tipo;
        int precio;
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
    }
}
