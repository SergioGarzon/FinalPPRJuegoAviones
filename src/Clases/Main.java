
package Clases;

import java.awt.Button;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends Frame implements ActionListener {

    private Frame frame;
    private Button boton, boton2;
    private Label etiqueta1, etiqueta2, etiqueta3, etiqueta4, etiqueta5;

    public Main() {
        this.frame = new Frame();
        this.frame.setVisible(true);
        this.frame.setTitle("Caratula Presentación");
        this.frame.setSize(500, 425);
        this.frame.setLocationRelativeTo(null);

        this.boton = new Button();
        this.boton.setLabel("Continuar");
        this.boton.setBounds(new Rectangle(180, 325, 120, 25));

        this.boton2 = new Button();
        this.boton2.setLabel("Salir");
        this.boton2.setBounds(new Rectangle(180, 355, 120, 25));

        this.etiqueta1 = new Label();
        this.etiqueta1.setText("Trabajo De Investigación");
        this.etiqueta1.setFont(new Font("Arial", Font.BOLD, 30));
        this.etiqueta1.setBounds(new Rectangle(65, 25, 400, 80));

        this.etiqueta2 = new Label();
        this.etiqueta2.setText("Cátedra: Paradigmas de Programación");
        this.etiqueta2.setFont(new Font("Arial", Font.BOLD, 15));
        this.etiqueta2.setBounds(new Rectangle(75, 140, 400, 25));

        this.etiqueta3 = new Label();
        this.etiqueta3.setText("Alumno: Garzón, Sergio Gabriel. Legajo: 54330");
        this.etiqueta3.setFont(this.etiqueta2.getFont());
        this.etiqueta3.setBounds(new Rectangle(75, 180, 400, 25));

        this.etiqueta4 = new Label();
        this.etiqueta4.setText("Curso: 2k6");
        this.etiqueta4.setFont(this.etiqueta2.getFont());
        this.etiqueta4.setBounds(new Rectangle(75, 220, 400, 25));

        this.etiqueta5 = new Label();
        this.etiqueta5.setText("Coordinador de Cátedra: Ing. Tymoschuk");
        this.etiqueta5.setFont(this.etiqueta2.getFont());
        this.etiqueta5.setBounds(new Rectangle(75, 260, 400, 25));

        Container contenedor = new Container();
        contenedor.setLayout(null);

        contenedor.add(this.boton);
        contenedor.add(this.boton2);
        contenedor.add(this.etiqueta1);
        contenedor.add(this.etiqueta2);
        contenedor.add(this.etiqueta3);
        contenedor.add(this.etiqueta4);
        contenedor.add(this.etiqueta5);

        this.frame.add(contenedor);

        this.boton.addActionListener(this);
        this.boton2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.boton) {
            this.frame.setVisible(false);
            new Principal();
        }
        else
            System.exit(0);
    }

    static public void main(String args[]) {
        new Main();
    }



}
