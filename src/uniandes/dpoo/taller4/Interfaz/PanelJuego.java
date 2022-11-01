package uniandes.dpoo.taller4.Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.*;

public class PanelJuego extends JPanel implements MouseListener{

    private Tablero principal;
    private int ultima_columna;
    private int ultima_fila;
    private int [][] cantidades;
    private int size;

    public PanelJuego(int size) {
        this.size = size;
        JPanel paneBotones = new JPanel();
		paneBotones.setLayout(new GridLayout(size,size));
		paneBotones.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		
		JLabel casillas[][] = new JLabel[size][size];
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				casillas[i][j] = new JLabel("M");
				paneBotones.add(casillas[i][j]);
				casillas[i][j].addMouseListener(this);
			}
		}
		
		this.add(paneBotones, BorderLayout.CENTER);

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel casilla = (JLabel) e.getSource();
        System.out.println(casilla);
        //casilla.setIcon(new ImageIcon("data/imagenes/interrogacion.png"));


        
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

    private int[] convertirCoordenadasACasilla(int x, int y)
    {
        int ladoTablero = this.size;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
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

}
