
package Clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MediaPanel extends JPanel {

    private JFrame frame;
    private ImageIcon imagen;
    private JButton boton, boton2, boton3, boton4, boton5;
    private Avion avion;
    private AvionEnemigoMisil avionenemigo;
    private Clip disparo;
    private static boolean sonidoDisparo;

    public MediaPanel(JFrame frame) {

        this.frame = frame;

        try {
            this.imagen = new ImageIcon(getClass().getResource("/Imagenes/Oceano.jpg"));
        }
        catch(Exception e) {}

        this.avion = new Avion(frame);
        this.avionenemigo = new AvionEnemigoMisil(frame, this);

        MediaPanel.sonidoDisparo = true;

        this.setLayout(null);
        this.setVisible(true);

        try {
            this.disparo = AudioSystem.getClip();

            this.disparo.open(AudioSystem.getAudioInputStream(
                    new File(System.getProperty("user.dir") + "/Sonidos/explode.wav")));           
            
            
        }
        catch (Exception e2) {}

        this.frame.add(this);
        this.boton = new JButton();
        this.boton.setText("Izquierda");
        this.boton.setBounds(new Rectangle(100, frame.getHeight() - (frame.getHeight() / 4) + 50, 150, 25));

        this.boton2 = new JButton();
        this.boton2.setText("Arriba");
        this.boton2.setBounds(new Rectangle(250, frame.getHeight() - (frame.getHeight() / 4) + 25, 150, 25));

        this.boton3 = new JButton();
        this.boton3.setText("Derecha");
        this.boton3.setBounds(new Rectangle(400, frame.getHeight() - (frame.getHeight() / 4) + 50, 150, 25));

        this.boton4 = new JButton();
        this.boton4.setText("Abajo");
        this.boton4.setBounds(new Rectangle(250, frame.getHeight() - (frame.getHeight() / 4) + 75, 150, 25));

        this.boton5 = new JButton();
        this.boton5.setText("Disparar");
        this.boton5.setBounds(new Rectangle(650, frame.getHeight() - (frame.getHeight() / 4) + 50, 200, 25));

        this.add(boton);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);
        this.add(boton5);

        this.boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Avion.posicionXMenos();
                repaint();
            }
        });

        this.boton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Avion.posicionYMenos();
                repaint();
            }
        });

        this.boton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Avion.posicionXMas();
                repaint();
            }
        });

        this.boton4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Avion.posicionYMas();
                repaint();
            }
        });

        this.boton5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                EventoDisparo(e);
            }
        });

    }

    public static void setSonidoDisparo(boolean disparar) {
        MediaPanel.sonidoDisparo = disparar;
    }

    private void EventoDisparo(ActionEvent e) {

        AvionEnemigoMisil.setDisparar(true);

        if(MediaPanel.sonidoDisparo)
            try {
                this.disparo.loop(0);
                
                
            }
            catch(Exception e2) {
            }
    }

    @Override
    public void paintComponent(Graphics g) {

        try {
            Dimension d = getSize();
            g.drawImage(imagen.getImage(), 0, 0, d.width, d.height,this);
        }
        catch(Exception e) {
        }

        avion.dibujar(g);

        avionenemigo.dibujar(g);

        g.setColor(Color.black);
        g.fillRect(0, frame.getHeight() - (frame.getHeight() / 4), frame.getWidth(), frame.getHeight());

        setOpaque(false);

        super.paintComponent(g);
    }


}