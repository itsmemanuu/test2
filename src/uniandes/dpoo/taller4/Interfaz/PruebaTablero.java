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

        if (widthT < heightT) {
            width = widthT;
        }
        else {
            width = heightT;
        }
        
        int casilla = width/this.size;
                
        for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) {
                this.cantidades[i][j] = 0;
                if (tableroActual[i][j])
                {
                    h.drawImage(prendido.getImage(), i*casilla, j*casilla, casilla, casilla, this );
                }
                else
                {
                    h.drawImage(apagado.getImage(), i*casilla, j*casilla, casilla, casilla, this);
                }
                // h.setColor(new Color(14, 0, 54));
                // h.drawRect(i*casilla, j*casilla, casilla, casilla);
                addMouseListener(this);
            }
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        cantidades[casilla[0]][casilla[1]]++;
        principal.jugar(casilla[0], casilla[1]);
        this.ultima_fila = casilla[0];
        this.ultima_columna = casilla[1];
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