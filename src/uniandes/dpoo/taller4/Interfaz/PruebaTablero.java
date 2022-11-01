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
        super.paintComponent(h);
        this.setBackground(Color.WHITE);
        ImageIcon apagado = new ImageIcon(getClass().getResource("apagado.png"));
        ImageIcon prendido = new ImageIcon(getClass().getResource("prendido.png"));
        
        int width = 400;
        
        int casilla = width/this.size;
        
        
        for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) {
                if (tableroActual[i][j])
                {
                    h.drawImage(prendido.getImage(), i*casilla, j*casilla, casilla, casilla, this);
                }
                else
                {
                    h.drawImage(apagado.getImage(), i*casilla, j*casilla, casilla, casilla, this);
                }
                // h.setColor(new Color(14, 0, 54));
                // h.drawRect(i*casilla, j*casilla, casilla, casilla);
            }
        }
    }
} 