package uniandes.dpoo.taller4.Interfaz;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import uniandes.dpoo.taller4.*;


public class PruebaTablero extends JPanel{

    private int size;
    private boolean[][] tableroActual;

    PruebaTablero(int size, boolean[][] tableroActual) {
        this.size = size;
        this.tableroActual = tableroActual;
    }

    public void paintComponent(Graphics h) {
        System.out.println("paintComponent");
        super.paintComponent(h);
        this.setBackground(Color.WHITE);
        h.setColor(Color.PINK);

        int width = 400;

        int casilla = width/this.size;

        h.drawRect(50, 50, casilla, casilla);

        for (int i = 1; i<size; i++) {
            for (int j = 1; j<size; j++) {
                if (tableroActual[i][j])
                {
                    System.out.println("entro");
                    h.fillRect(i*casilla, j*casilla, casilla, casilla);
                }
                else
                {

                    h.drawRect(i*casilla, j*casilla, casilla, casilla);
                }
            }
        }

    }
} 