package uniandes.dpoo.taller4.Interfaz;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


import uniandes.dpoo.taller4.modelo.*;


public class PruebaTablero extends JPanel implements MouseListener{

    private int size;
    private int width;
    private boolean[][] tableroActual;
    private int[][] cantidades;
    private int ultima_columna;
    private int ultima_fila;
    private Tablero principal;

    PruebaTablero(boolean[][] tableroActual, Tablero principal) {
        this.size = principal.darTablero().length;
        this.tableroActual = tableroActual;
        this.principal = principal;
        this.cantidades = new int[size][size];
    }

    public void paintComponent(Graphics h) {
        super.paintComponent(h);
        this.setBackground(Color.WHITE);
        ImageIcon apagado = new ImageIcon(getClass().getResource("apagado.png"));
        ImageIcon prendido = new ImageIcon(getClass().getResource("prendido.png"));

        int widthT = getWidth();
        int heightT = getHeight();
        int spacingX;
        int spacingY;
        int casilla = width/this.size;

        if (widthT < heightT) {
            width = widthT;
            spacingX = 0;
            spacingY = (heightT - (casilla*size)) / 2;

        }
        else {
            width = heightT;
            spacingX = (widthT - (casilla*size)) / 2;
            spacingY = 0;
        }

        for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) {
                this.cantidades[i][j] = 0;
                if (tableroActual[j][i])
                {
                    h.drawImage(prendido.getImage(), i*casilla + spacingX, j*casilla + spacingY, casilla, casilla, this);
                }
                else
                {
                    h.drawImage(apagado.getImage(), i*casilla + spacingX, j*casilla + spacingY, casilla, casilla, this);
                }
            }
        }
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub 
    }
    
    
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        principal.jugar(casilla[0], casilla[1]);
        cantidades[casilla[0]][casilla[1]]++;
        this.ultima_fila = casilla[0];
        this.ultima_columna = casilla[1];
        revalidate();
        repaint();  
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    private int[] convertirCoordenadasACasilla(int x, int y)
    {
        int ladoTablero = size;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }
} 