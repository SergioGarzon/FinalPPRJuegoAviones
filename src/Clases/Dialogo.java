
package Clases;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class Dialogo extends JDialog implements ActionListener {

    private boolean sonido;
    private JLabel etiqueta, etiqueta2, etiqueta3, etiqueta4, etiqueta5, etiqueta6;
    private JRadioButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8
            , boton9, boton10, boton11, boton12;
    private JButton botonAceptar, botonCancelar;
    private Clip musicaFondo;

    public Dialogo(Clip sonido) {

        this.setSize(400, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Opciones del Juego");
        this.setResizable(false);

        this.sonido = true;
        this.musicaFondo = sonido;

        this.etiqueta = new JLabel();
        this.etiqueta.setText("Sonido de botones: ");
        this.etiqueta.setBounds(new Rectangle(25, 25, 125, 25));

        this.etiqueta2 = new JLabel();
        this.etiqueta2.setText("Sonido de fondo: ");
        this.etiqueta2.setBounds(new Rectangle(25, 75, 125, 25));

        this.etiqueta3 = new JLabel();
        this.etiqueta3.setText("Sonido de inicio : ");
        this.etiqueta3.setBounds(new Rectangle(25, 125, 125, 25));

        this.etiqueta4 = new JLabel();
        this.etiqueta4.setText("Sonido de disparo: ");
        this.etiqueta4.setBounds(new Rectangle(25, 175, 125, 25));

        this.etiqueta5 = new JLabel();
        this.etiqueta5.setText("Sonido de colisión: ");
        this.etiqueta5.setBounds(new Rectangle(25, 225, 125, 25));

        this.etiqueta6 = new JLabel();
        this.etiqueta6.setText("Sonido de colisión 2: ");
        this.etiqueta6.setBounds(new Rectangle(25, 275, 125, 25));

        this.boton1 = new JRadioButton();
        this.boton1.setText("Activar");
        this.boton1.setBounds(new Rectangle(150, 25, 100, 25));

        this.boton2 = new JRadioButton();
        this.boton2.setText("Desactivar");
        this.boton2.setBounds(new Rectangle(150, 50, 100, 25));

        this.boton3 = new JRadioButton();
        this.boton3.setText("Activar");
        this.boton3.setBounds(new Rectangle(150, 75, 100, 25));

        this.boton4 = new JRadioButton();
        this.boton4.setText("Desactivar");
        this.boton4.setBounds(new Rectangle(150, 100, 100, 25));

        this.boton5 = new JRadioButton();
        this.boton5.setText("Activar");
        this.boton5.setBounds(new Rectangle(150, 125, 100, 25));

        this.boton6 = new JRadioButton();
        this.boton6.setText("Desactivar");
        this.boton6.setBounds(new Rectangle(150, 150, 100, 25));

        this.boton7 = new JRadioButton();
        this.boton7.setText("Activar");
        this.boton7.setBounds(new Rectangle(150, 175, 100, 25));

        this.boton8 = new JRadioButton();
        this.boton8.setText("Desactivar");
        this.boton8.setBounds(new Rectangle(150, 200, 100, 25));

        this.boton9 = new JRadioButton();
        this.boton9.setText("Activar");
        this.boton9.setBounds(new Rectangle(150, 225, 100, 25));

        this.boton10 = new JRadioButton();
        this.boton10.setText("Desactivar");
        this.boton10.setBounds(new Rectangle(150, 250, 100, 25));

        this.boton11 = new JRadioButton();
        this.boton11.setText("Activar");
        this.boton11.setBounds(new Rectangle(150, 275, 100, 25));

        this.boton12 = new JRadioButton();
        this.boton12.setText("Desactivar");
        this.boton12.setBounds(new Rectangle(150, 300, 100, 25));

        this.botonAceptar = new JButton();
        this.botonAceptar.setText("Aceptar");
        this.botonAceptar.setBounds(new Rectangle(90, 350, 100, 25));

        this.botonCancelar = new JButton();
        this.botonCancelar.setText("Cancelar");
        this.botonCancelar.setBounds(new Rectangle(220, 350, 100, 25));

        this.add(etiqueta);
        this.add(etiqueta2);
        this.add(etiqueta3);
        this.add(etiqueta4);
        this.add(etiqueta5);
        this.add(etiqueta6);
        this.add(boton1);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);
        this.add(boton5);
        this.add(boton6);
        this.add(boton7);
        this.add(boton8);
        this.add(boton9);
        this.add(boton10);
        this.add(boton11);
        this.add(boton12);
        this.add(botonAceptar);
        this.add(botonCancelar);

        this.boton1.addActionListener(this);
        this.boton2.addActionListener(this);
        this.boton3.addActionListener(this);
        this.boton4.addActionListener(this);
        this.boton5.addActionListener(this);
        this.boton6.addActionListener(this);
        this.boton7.addActionListener(this);
        this.boton8.addActionListener(this);
        this.boton9.addActionListener(this);
        this.boton10.addActionListener(this);
        this.boton11.addActionListener(this);
        this.boton12.addActionListener(this);
        this.botonAceptar.addActionListener(this);
        this.botonCancelar.addActionListener(this);

        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                PanelFrame.EnabledBotones(true);
            }
        });
    }

    public boolean getSonido() {
        return this.sonido;
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.boton3)
            this.boton4.setSelected(false);

        if(e.getSource() == this.boton4)
            this.boton3.setSelected(false);

        if(e.getSource() == this.boton1)
            this.boton2.setSelected(false);

        if(e.getSource() == this.boton2)
            this.boton1.setSelected(false);

        if(e.getSource() == this.boton5)
            this.boton6.setSelected(false);

        if(e.getSource() == this.boton6)
            this.boton5.setSelected(false);

        if(e.getSource() == this.boton7)
            this.boton8.setSelected(false);

        if(e.getSource() == this.boton8)
            this.boton7.setSelected(false);

        if(e.getSource() == this.boton9)
            this.boton10.setSelected(false);

        if(e.getSource() == this.boton10)
            this.boton9.setSelected(false);

        if(e.getSource() == this.boton11)
            this.boton12.setSelected(false);

        if(e.getSource() == this.boton12)
            this.boton11.setSelected(false);


        if(e.getSource() == this.botonAceptar) {
            if(this.boton2.isSelected())
                this.sonido = false;
            else
                this.sonido = true;

            if(this.boton4.isSelected())
                this.musicaFondo.stop();
            else
                this.musicaFondo.start();

            if(this.boton6.isSelected())
                PanelFrame.BanderaSonidoStart(false);
            else
                PanelFrame.BanderaSonidoStart(true);

            if(this.boton7.isSelected())
                MediaPanel.setSonidoDisparo(true);
            else
                MediaPanel.setSonidoDisparo(false);

            if(this.boton10.isSelected())
                AvionEnemigoMisil.setSonidoColision(false);
            else
                AvionEnemigoMisil.setSonidoColision(true);

            if(this.boton12.isSelected())
                AvionEnemigoMisil.setSonidoColision2(false);
            else
                AvionEnemigoMisil.setSonidoColision2(true);

            this.setVisible(false);
            PanelFrame.EnabledBotones(true);
            PanelFrame.Bandera(true);
        }

        if(e.getSource() == this.botonCancelar) {
            this.setVisible(false);
            PanelFrame.EnabledBotones(true);
            PanelFrame.Bandera(true);
        }
    }

}
