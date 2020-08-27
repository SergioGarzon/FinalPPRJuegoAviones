
package Clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelFrame extends JPanel {

    private ImageIcon imagen;
    private static JButton boton, boton2, boton3;
    private JFrame frame;
    private Dialogo dialogo;
    private Clip sonido, sonidoStart;
    private static boolean bandera, banderaSonidoStart;
    private MediaPanel panel;

    public PanelFrame(final JFrame frame) {

        this.frame = frame;
        PanelFrame.bandera = true;
        this.panel = null;

        this.sonido = this.sonidoStart = null;
        PanelFrame.banderaSonidoStart = true;

        try {
            // Se obtiene un Clip de sonido
            this.sonido = AudioSystem.getClip();

            // Se carga con un fichero wav
            this.sonido.open(AudioSystem.getAudioInputStream(
               new File(System.getProperty("user.dir") + "/src/Sonidos/Cancion.wav")));

        } catch (Exception e) {}

        try {
            // Se obtiene un Clip de sonido
            this.sonidoStart = AudioSystem.getClip();

            // Se carga con un fichero wav
            this.sonidoStart.open(AudioSystem.getAudioInputStream(
               new File(System.getProperty("user.dir") + "/src/Sonidos/Hammer.wav")));
        }
        catch(Exception exception) {}

        this.dialogo = new Dialogo(sonido);

        try {
            this.imagen = new ImageIcon(getClass().getResource("/Imagenes/aviones.jpg"));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error al leer la imágen", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {   this.sonido.start();    } catch(Exception e) {}

        this.setLayout(null);

        boton = new JButton();
        boton.setText("Iniciar Partida");
        boton.setBounds(new Rectangle(Principal.ANCHO / 4 + ((Principal.ANCHO / 4) / 2), Principal.ALTO / 5 + 100
                , Principal.ANCHO / 4, 50));
        boton.setFont(new Font("Times New Roman", Font.BOLD, 25));
        boton.setForeground(Color.black);

        boton2 = new JButton();
        boton2.setText("Opciones");
        boton2.setBounds(new Rectangle(Principal.ANCHO / 4 + ((Principal.ANCHO / 4) / 2),
                (Principal.ALTO / 5)+ 200, Principal.ANCHO / 4, 50));
        boton2.setFont(PanelFrame.boton.getFont());
        boton2.setForeground(PanelFrame.boton.getForeground());
        boton2.setEnabled(true);

        boton3 = new JButton();
        boton3.setText("Salir del juego");
        boton3.setBounds(new Rectangle(Principal.ANCHO / 4 + ((Principal.ANCHO / 4) / 2),
                Principal.ALTO / 5 + 300, Principal.ANCHO / 4, 50));
        boton3.setFont(PanelFrame.boton.getFont());
        boton3.setForeground(PanelFrame.boton.getForeground());
        boton3.setEnabled(true);

        this.add(boton);
        this.add(boton2);
        this.add(boton3);

        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                SonidoJavaMidi();
            }
        });

        boton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                SonidoJavaMidi();
            }
        });

        boton3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                SonidoJavaMidi();
            }
        });

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventoBoton(e);
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventoBoton2(e);
            }
        });
    }

    public void EventoBoton2(ActionEvent e) {
        PanelFrame.boton.setEnabled(false);
        PanelFrame.boton2.setEnabled(false);
        PanelFrame.boton3.setEnabled(false);
        dialogo.setVisible(true);
        PanelFrame.bandera = false;
        Toolkit.getDefaultToolkit().beep();

        try {
            this.sonido.stop();
        }
        catch(Exception exception) {}
    }

    public void EventoBoton(ActionEvent e) {

        boolean xBand = false;

        try {
            this.sonido.stop();
        }
        catch(Exception exception) {}

        if(PanelFrame.banderaSonidoStart)
            try {
                this.sonidoStart.start();
                xBand = true;
            }
            catch(Exception exception) {}

        this.setVisible(false);

        if(xBand)
            try {
                Thread.sleep(750);
                this.sonidoStart.stop();
            }
            catch(Exception exception) {}

        panel = new MediaPanel(frame);

    }

    public static void BanderaSonidoStart(boolean b) {
        PanelFrame.banderaSonidoStart = b;
    }

    public static void EnabledBotones(boolean b) {
        PanelFrame.boton.setEnabled(b);
        PanelFrame.boton2.setEnabled(b);
        PanelFrame.boton3.setEnabled(b);
    }

    public static void Bandera(boolean b) {
        PanelFrame.bandera = b;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension d = getSize();
        try {
            g.drawImage(imagen.getImage(), 0, 0, d.width, d.height,this);
        }
        catch(Exception e) {}

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.drawString("Guerra Áerea", Principal.ANCHO / 4,
                Principal.ALTO / 5);

        setOpaque(false);
    }

    public void SonidoJavaMidi() {
        if(dialogo.getSonido() && bandera)
            try {
                Synthesizer synthesizer = MidiSystem.getSynthesizer();
                synthesizer.open();

                MidiChannel[] channels = synthesizer.getChannels();

                channels[0].noteOn(77, 500);
                Thread.sleep(300);
                channels[0].noteOff(77);

                synthesizer.close();
            }
            catch(Exception e2) {
                e2.printStackTrace();
            }
    }


}


