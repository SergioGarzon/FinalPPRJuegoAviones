
package Clases;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Avion {

    private static ImageIcon imagen;
    private static int posicionX, posicionY;
    private JFrame frame;
    private static int ALTO, ANCHO;
    private static boolean bandera;

    public Avion(JFrame frame) {

        String ruta = System.getProperty("user.dir");
        
        try {
            imagen = new ImageIcon(ruta + "/src/Imagenes/AvionProtagonista.jpg");
        }
        catch(Exception e) {}

        this.frame = frame;
        Avion.bandera = false;

        Avion.ALTO = frame.getWidth();
        Avion.ANCHO = frame.getHeight();

        Avion.posicionX = Avion.ANCHO / 2 - 25;
        Avion.posicionY = (Avion.ALTO / 3) + 25;
    }


    public static void posicionXMenos() {
        if(posicionX > 0)
            posicionX -= 50;
    }

    public static void posicionXMas() {
        if(posicionX <= ANCHO)
            posicionX += 50;
    }

    public static void posicionYMenos() {
        if(posicionY > 0)
            posicionY -= 50;
    }

    public static void posicionYMas() {
        if(posicionY < ALTO)
            posicionY += 50;
    }

    public static int getPosicionX() {
        return posicionX;
    }

    public static int getPosicionY() {
        return posicionY;
    }

    public static int getAnchoImagen() {
        return imagen.getIconWidth();
    }

    public static int getAltoImagen() {
        return imagen.getIconHeight();
    }

    public void dibujar(Graphics g) {

        try {
            g.drawImage(imagen.getImage(), Avion.posicionX, Avion.posicionY, null);
        }
        catch(Exception e) {}
    }

}


