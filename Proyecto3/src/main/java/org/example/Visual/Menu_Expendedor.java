package org.example.Visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu_Expendedor extends JPanel implements ActionListener {

    private JButton boton1;
    private JButton boton2;

    public Menu_Expendedor(){
        super();
        this.setLayout(new FlowLayout()); //esto crea automaticamente el orden parece

        boton1 = new JButton("Derecho"); //nombre del boton
        boton1.setMnemonic(KeyEvent.VK_D); //Esta parte hace que al apretar alt+d se presiona sin necesidad del click
        boton1.setActionCommand("enable"); //


        boton2 = new JButton("Izquierdo");
        boton2.setMnemonic(KeyEvent.VK_A); //Lo mismo pero con a
        boton2.setActionCommand("disable");


        boton1.setToolTipText("Click para deshabilitar el Izquierdo.");
        boton2.setToolTipText("Click para deshabilitar el Derecho.");



        boton1.setEnabled(true);
        boton2.setEnabled(false);


        boton1.addActionListener(this);
        boton2.addActionListener(this);


        add(boton1);
        add(boton2);

    }

    @Override
    //cambia de estado entre poder apretar a no poder apretar
    public void actionPerformed(ActionEvent e) {
        if ("disable".equals(e.getActionCommand())) {
            boton1.setEnabled(true);
            boton2.setEnabled(false);

        } else {
            boton1.setEnabled(false);
            boton2.setEnabled(true);
        }
    }
}
