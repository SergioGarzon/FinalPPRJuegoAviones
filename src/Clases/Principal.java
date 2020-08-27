package Clases;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Principal extends JFrame {

    private static JFrame ventana;
    private JMenu jmenu, jmenu2;
    private JMenuBar menuBar;
    private static JMenuItem menuitem, menuitem2, menuitem3;
    private static PanelFrame panel;
    public static int ANCHO, ALTO;

    @SuppressWarnings("empty-statement")
    public Principal() {
        
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (Exception e2) {
        }

        ventana = new JFrame();
        ventana.setTitle("Trabajo Final PPR, 2K6");
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Principal.ANCHO = ventana.getWidth();
        Principal.ALTO = ventana.getHeight();

        menuitem = new JMenuItem();
        menuitem2 = new JMenuItem();;
        menuitem3 = new JMenuItem();
        menuitem.setText("Resetear");
        menuitem2.setText("Salir del juego");
        menuitem3.setText("Como jugar");

        menuBar = new JMenuBar();

        jmenu = new JMenu();
        jmenu.setText("Opciones");
        jmenu2 = new JMenu();
        jmenu2.setText("Ayuda");

        jmenu.add(menuitem);
        jmenu.add(menuitem2);

        jmenu2.add(menuitem3);

        menuBar.add(jmenu);
        menuBar.add(jmenu2);

        ventana.setJMenuBar(menuBar);

        panel = new PanelFrame(ventana);

        ventana.add(panel, BorderLayout.CENTER);

        menuitem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Salir();
            }
        });

        menuitem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reset();
            }
        });

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                Salir();
            }
        });

        menuitem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ventana.setEnabled(false);

                JDialog ventanaSecundaria = new JDialog(ventana, "Ventana secundaria");

                JLabel etiqueta, etiqueta2, etiqueta3, etiqueta4, etiqueta5, etiqueta6;

                etiqueta = new JLabel("Usted tiene que manejar el avión");
                etiqueta2 = new JLabel("con los botones presentes en la pantalla,");
                etiqueta3 = new JLabel("\nDeberá disparar y evitar colisionar");
                etiqueta4 = new JLabel("\ncon los aviones enemigos que se presenten.");
                etiqueta5 = new JLabel("\nA médida que avanza de nivel la dificultad");
                etiqueta6 = new JLabel("\naumentará.");

                etiqueta.setBounds(new Rectangle(5, 5, 475, 25));
                etiqueta2.setBounds(new Rectangle(5, 35, 475, 25));
                etiqueta3.setBounds(new Rectangle(5, 65, 475, 25));
                etiqueta4.setBounds(new Rectangle(5, 95, 475, 25));
                etiqueta5.setBounds(new Rectangle(5, 125, 475, 25));
                etiqueta6.setBounds(new Rectangle(5, 155, 475, 25));

                etiqueta.setFont(new Font("Times New Roman", Font.BOLD, 25));
                etiqueta2.setFont(etiqueta.getFont());
                etiqueta3.setFont(etiqueta.getFont());
                etiqueta4.setFont(etiqueta.getFont());
                etiqueta5.setFont(etiqueta.getFont());
                etiqueta6.setFont(etiqueta.getFont());

                ventanaSecundaria.setLayout(null);
                ventanaSecundaria.pack();
                ventanaSecundaria.setSize(495, 225);
                ventanaSecundaria.setVisible(true);
                ventanaSecundaria.setResizable(false);

                ventanaSecundaria.getContentPane().add(etiqueta);
                ventanaSecundaria.add(etiqueta2);
                ventanaSecundaria.add(etiqueta3);
                ventanaSecundaria.add(etiqueta4);
                ventanaSecundaria.add(etiqueta5);
                ventanaSecundaria.add(etiqueta6);
                ventanaSecundaria.setLocationRelativeTo(null);

                ventanaSecundaria.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent we) {
                        Principal.Enabled(true);
                    }
                });
            }
        });
    }

    public static void Agregar(JPanel panel) {
        if (panel != null) {
            ventana.add(panel);
        }
    }

    public static void Enabled(Boolean b) {
        ventana.setEnabled(b);
    }

    public static void Reset() {
        Toolkit.getDefaultToolkit().beep();

        AvionEnemigoMisil.setDesactivar(true);

        panel.setVisible(true);
    }

    public void Salir() {
        Toolkit.getDefaultToolkit().beep();

        int respuesta = new Integer(0);
        respuesta = JOptionPane.showOptionDialog(ventana, "Desea salir?", "Confirme cierre",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new Object[]{"Cerrar programa", "Cancelar"}, "");

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
