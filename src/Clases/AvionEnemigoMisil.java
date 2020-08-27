
package Clases;

import java.awt.Graphics;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AvionEnemigoMisil {

    private static ImageIcon imagen, imagen2, imagen3, imagen4, imagen5, imagen6, imagenMisil;
    private static int posicionEX1, posicionEY1, posicionEX2, posicionEY2,
            posicionEX3, posicionEY3, ALTO, ANCHO, posicionEX4, posicionEY4,
            posicionEX5, posicionEY5, posicionEX6, posicionEY6, misilX, misilY;
    private JFrame frame;
    private JPanel panel;
    private TimerTask tiempo;
    private Timer reloj;
    private Clip colision, sonido;
    private static boolean desactivar, sonidoColision, sonidoColision2, disparar;

    public AvionEnemigoMisil(final JFrame frame, final JPanel panel) {

        this.panel = panel;
        this.frame = frame;
        AvionEnemigoMisil.desactivar = false;
        AvionEnemigoMisil.sonidoColision = true;
        AvionEnemigoMisil.sonidoColision2 = true;
        AvionEnemigoMisil.disparar = false;
        
        String ruta = System.getProperty("user.dir");
        
        try {
            imagenMisil = new ImageIcon(ruta + "/src/Imagenes/Misil.jpg");
            imagen = new ImageIcon(ruta + "/src/Imagenes/AvionEnemigo.jpg");
            imagen2 = new ImageIcon(ruta + "/src/Imagenes/AvionEnemigo2.jpg");
            imagen3 = new ImageIcon(ruta + "/src/Imagenes/AvionEnemigo3.jpg");
            imagen4 = new ImageIcon(ruta + "/src/Imagenes/AvionEnemigo4.jpg");
            imagen5 = new ImageIcon(ruta + "/src/Imagenes/AvionEnemigo5.jpg");
            imagen6 = new ImageIcon(ruta + "/src/Imagenes/AvionEnemigo6.jpg");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this.panel, "Hola mundo");
        }

        AvionEnemigoMisil.ALTO = frame.getWidth();
        AvionEnemigoMisil.ANCHO = frame.getHeight();

        AvionEnemigoMisil.posicionEY1 = - 300;
        AvionEnemigoMisil.posicionEX1 = 100;

        AvionEnemigoMisil.posicionEX2 = ANCHO - 50;
        AvionEnemigoMisil.posicionEY2 = -500;

        AvionEnemigoMisil.posicionEX3 = 20;
        AvionEnemigoMisil.posicionEY3 = -2500;

        AvionEnemigoMisil.posicionEX4 = 20;
        AvionEnemigoMisil.posicionEY4 = -2000;

        AvionEnemigoMisil.posicionEX5 = ANCHO / 2;
        AvionEnemigoMisil.posicionEY5 = -5000;

        AvionEnemigoMisil.posicionEX6 = 0;
        AvionEnemigoMisil.posicionEY6 = -20000;

        AvionEnemigoMisil.misilX = Avion.getPosicionX() + (Avion.getAnchoImagen() / 2);
        AvionEnemigoMisil.misilY = Avion.getPosicionY() + (Avion.getAltoImagen() / 2);

        tiempo = new TimerTask() {
            @Override
            @SuppressWarnings("empty-statement")
            public void run() {
                try {
                    int i;
                    i = 0;

                    boolean bandera = true;

                    while(bandera && !colision()) {

                        posicionEY1 += i;
                        posicionEY2 += i;
                        posicionEY3 += i;
                        posicionEY4 += i;
                        posicionEY5 += i;
                        posicionEY6 += i;

                        i++;

                        posicionEX1 += 10;
                        posicionEX2 -= 20;
                        posicionEX4 += 5;

                        Thread.sleep(100);

                        panel.repaint();

                        if(disparar) {

                            AvionEnemigoMisil.misilX = Avion.getPosicionX();
                            AvionEnemigoMisil.misilY -= 25;

                            if(misilY <= 0) {
                                AvionEnemigoMisil.disparar = false;
                            }

                            if(misilY >= AvionEnemigoMisil.posicionEY1 &&
                                    misilX <= (AvionEnemigoMisil.posicionEX1 + AvionEnemigoMisil.imagen.getIconWidth())
                                    && misilX >= AvionEnemigoMisil.posicionEX1) {
                                AvionEnemigoMisil.posicionEY1 = - 300;
                                AvionEnemigoMisil.posicionEX1 = 100;
                                colisionMisilAvionEnemigo();
                                AvionEnemigoMisil.disparar = false;
                            }

                            if(misilY >= AvionEnemigoMisil.posicionEX2 &&
                                    misilX <= (AvionEnemigoMisil.posicionEX2 + AvionEnemigoMisil.imagen2.getIconWidth())
                                    && misilX >= AvionEnemigoMisil.posicionEX2) {
                                AvionEnemigoMisil.posicionEX2 = ANCHO - 50;
                                AvionEnemigoMisil.posicionEY2 = -500;
                                colisionMisilAvionEnemigo();
                                AvionEnemigoMisil.disparar = false;
                            }

                            if(misilY >= AvionEnemigoMisil.posicionEX3 &&
                                    misilX <= (AvionEnemigoMisil.posicionEX3 + AvionEnemigoMisil.imagen3.getIconWidth())
                                    && misilX >= AvionEnemigoMisil.posicionEY3) {
                                AvionEnemigoMisil.posicionEX3 = 20;
                                AvionEnemigoMisil.posicionEY3 = -2500;
                                colisionMisilAvionEnemigo();
                                AvionEnemigoMisil.disparar = false;
                            }

                            if(misilY >= AvionEnemigoMisil.posicionEX4 &&
                                    misilX <= (AvionEnemigoMisil.posicionEX4 + AvionEnemigoMisil.imagen4.getIconWidth())
                                    && misilX >= AvionEnemigoMisil.posicionEY4) {
                                AvionEnemigoMisil.posicionEX4 = 20;
                                AvionEnemigoMisil.posicionEY4 = -2000;
                                colisionMisilAvionEnemigo();
                                AvionEnemigoMisil.disparar = false;
                            }

                            if(misilY >= AvionEnemigoMisil.posicionEX5 &&
                                    misilX <= (AvionEnemigoMisil.posicionEX5 + AvionEnemigoMisil.imagen5.getIconWidth())
                                    && misilX >= AvionEnemigoMisil.posicionEY5) {
                                AvionEnemigoMisil.posicionEX5 = ANCHO / 2;
                                AvionEnemigoMisil.posicionEY5 = -5000;
                                colisionMisilAvionEnemigo();
                                AvionEnemigoMisil.disparar = false;
                            }

                            if(misilY >= AvionEnemigoMisil.posicionEX6 &&
                                    misilX <= (AvionEnemigoMisil.posicionEX6 + AvionEnemigoMisil.imagen6.getIconWidth())
                                    && misilX >= AvionEnemigoMisil.posicionEY6) {
                                AvionEnemigoMisil.posicionEX6 = 0;
                                AvionEnemigoMisil.posicionEY6 = -20000;
                                colisionMisilAvionEnemigo();
                                AvionEnemigoMisil.disparar = false;
                            }
                        }

                        if(posicionEY6 >= 20) {
                            posicionEX6 += 75;
                        }

                        if(posicionEY1 > 1000 && posicionEX1 < ANCHO) {
                            i = 0;
                            posicionEY1 = - 300;
                            posicionEX1 += 75;
                        }

                        if(posicionEY2 > 1000 && posicionEX2 < ANCHO) {
                            posicionEY2 = -500;
                            posicionEX2 -= 50;
                        }

                        if(posicionEY3 > 1000)
                            posicionEY3 = -2500;

                        if(posicionEX1 > ANCHO)
                            posicionEX1 = 0;

                        if(posicionEX2 < 0)
                            posicionEX2 = ANCHO - 50;

                        if(posicionEY4 > 1000 && posicionEX4 > ANCHO) {
                            posicionEY4 = -5000;
                            posicionEX4 = -200;
                        }

                        if(posicionEY5 > 1000)
                            posicionEY5 = -5000;

                        if(posicionEY6 > 1000) {
                            posicionEY6 = -20000;
                            posicionEX6 = 0;
                        }

                        if(!disparar) {
                            AvionEnemigoMisil.misilX = Avion.getPosicionX() + (Avion.getAnchoImagen() / 2);
                            AvionEnemigoMisil.misilY = Avion.getPosicionY() + (Avion.getAltoImagen() / 2);
                        }

                    }

                    if(colision()) {

                        tiempo.cancel();
                        reloj.cancel();

                        if(AvionEnemigoMisil.sonidoColision) {
                            try {
                                colision = AudioSystem.getClip();

                                colision.open(AudioSystem.getAudioInputStream(
                                        new File(System.getProperty("user.dir") + "/src/Sonidos/Colision.wav")));

                                colision.start();

                                Thread.sleep(1000);

                                colision.stop();
                            }
                            catch(Exception e) {}

                        }

                        JOptionPane.showMessageDialog(frame, "Perdiste!");

                        Principal.Reset();
                    }

                    if(AvionEnemigoMisil.desactivar) {
                        tiempo.cancel();
                        reloj.cancel();
                    }

                }
                catch(InterruptedException e) {}
            }
        };
        reloj = new Timer();
        reloj.scheduleAtFixedRate(tiempo, 1000, 400);
    }

    public static void setSonidoColision(boolean b) {
        AvionEnemigoMisil.sonidoColision = b;
    }

    public static boolean getSonidoColision() {
        return AvionEnemigoMisil.sonidoColision;
    }

    public void colisionMisilAvionEnemigo() {
        if(AvionEnemigoMisil.sonidoColision2)
          try {
              sonido = AudioSystem.getClip();

              sonido.open(AudioSystem.getAudioInputStream(
                      new File(System.getProperty("user.dir") + "/src/Sonidos/ColisionMisilAvion.wav")));

              sonido.start();

              Thread.sleep(100);

              sonido.stop();
          }
          catch(Exception e) {
          }
    }

    public boolean colision() {

        boolean b = false;

        int w1, h1, x1, y1, w2, h2, x2, y2, w3, h3, x3, y3, w4, h4, x4, y4,
                w5, h5, x5, y5, w6, h6, x6, y6, w7, h7, x7, y7;

        try {
            w1 = Avion.getAnchoImagen();
            h1 = Avion.getAltoImagen();
            x1 = Avion.getPosicionX();
            y1 = Avion.getPosicionY();

            w2 = imagen.getIconWidth();
            h2 = imagen.getIconHeight();
            x2 = posicionEX1;
            y2 = posicionEY1;

            w3 = imagen2.getIconWidth();
            h3 = imagen2.getIconHeight();
            x3 = posicionEX2;
            y3 = posicionEY2;

            w4 = imagen3.getIconWidth();
            h4 = imagen3.getIconHeight();
            x4 = posicionEX3;
            y4 = posicionEY3;

            w5 = imagen4.getIconWidth();
            h5 = imagen4.getIconHeight();
            x5 = posicionEX4;
            y5 = posicionEY4;

            w6 = imagen5.getIconWidth();
            h6 = imagen5.getIconHeight();
            x6 = posicionEX5;
            y6 = posicionEY5;

            w7 = imagen6.getIconWidth();
            h7 = imagen6.getIconHeight();
            x7 = posicionEX6;
            y7 = posicionEY6;

            if(((x1+w1)>x2+25)&&((x2+w2)>x1+25))
                if(((y1+h1-25)>y2)&&(y2+h2-25)>y1)
                    if((x1>(x2+w2-50)&&(x1+w1-50)<x2))
                        b = false;
                    else
                        b = true;

            if(((x1+w1)>x3+25)&&((x3+w3)>x1+25))
                if(((y1+h1-25)>y3)&&(y3+h3-25)>y1)
                    if((x1>(x3+w3-50)&&(x1+w1-50)<x3))
                        b = false;
                    else
                        b = true;

            if(((x1+w1)>x4+25)&&((x4+w4)>x1+25))
                if(((y1+h1-25)>y4)&&(y4+h4-25)>y1)
                    if((x1>(x4+w4-50)&&(x1+w1-50)<x4))
                        b = false;
                    else
                        b = true;

            if(((x1+w1)>x5+25)&&((x5+w5)>x1+25))
                if(((y1+h1-25)>y5)&&(y5+h5-25)>y1)
                    if((x1>(x5+w5-50)&&(x1+w1-50)<x5))
                        b = false;
                    else
                        b = true;

            if(((x1+w1)>x6+25)&&((x6+w6)>x1+25))
                if(((y1+h1-25)>y6)&&(y6+h6-25)>y1)
                    if((x1>(x6+w6-50)&&(x1+w1-50)<x6))
                        b = false;
                    else
                        b = true;

            if(((x1+w1)>x7+25)&&((x7+w7)>x1+25))
                if(((y1+h1-25)>y7)&&(y7+h7-25)>y1)
                    if((x1>(x7+w7-50)&&(x1+w1-50)<x7))
                        b = false;
                    else
                        b = true;
        }
        catch(Exception e) {}
        
        return(b);
    }

    public void dibujar(Graphics g) {
        try {            
            g.drawImage(imagen.getImage(), posicionEX1, posicionEY1, null);
            g.drawImage(imagen2.getImage(), posicionEX2, posicionEY2, null);
            g.drawImage(imagen3.getImage(), posicionEX3, posicionEY3, null);
            g.drawImage(imagen4.getImage(), posicionEX4, posicionEY4, null);
            g.drawImage(imagen5.getImage(), posicionEX5, posicionEY5, null);
            g.drawImage(imagen6.getImage(), posicionEX6, posicionEY6, null);

            if(AvionEnemigoMisil.disparar)
                g.drawImage(imagenMisil.getImage(), misilX, misilY, null);
        }
        catch(Exception e) {
        }
    }

    public static void setDisparar(boolean b) {
        AvionEnemigoMisil.disparar = b;
    }

    public static void setDesactivar(boolean b) {
        AvionEnemigoMisil.desactivar = b;
    }

    public static void setSonidoColision2(boolean b) {
        AvionEnemigoMisil.sonidoColision2 = b;
    }


}
