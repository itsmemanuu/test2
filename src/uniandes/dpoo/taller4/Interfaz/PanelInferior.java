package uniandes.dpoo.taller4.Interfaz;
import uniandes.dpoo.taller4.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.*;
import java.awt.event.*;

public class PanelInferior extends JPanel{
    int sizeTablero;
    private Tablero tablero;
    private boolean[][] tableroActual;
    private PanelSuperior panelSuperior;
    private InterfazLightsOut interfaz;

    public PanelInferior(PanelSuperior panelSuperior, InterfazLightsOut interfaz) {
        this.interfaz = interfaz;
        this.panelSuperior = panelSuperior;

        JPanel paneLbl = new JPanel();
        this.setBackground(Color.WHITE);
        paneLbl.setBackground(Color.WHITE);
    
		paneLbl.setLayout(new GridLayout(1,4, 0, 10));

        JLabel nuevoB = new JLabel("Jugadas:");
		paneLbl.add(nuevoB);

        JLabel reiniciarB = new JLabel("Reiniciar");
		paneLbl.add(reiniciarB);

        JLabel top10B = new JLabel("Top 10");
		paneLbl.add(top10B);

        JLabel jugadorB = new JLabel("Cambiar Jugador");
		paneLbl.add(jugadorB);

        this.add(paneLbl, BorderLayout.CENTER);
    }
}