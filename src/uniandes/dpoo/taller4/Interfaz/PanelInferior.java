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
    private  JLabel jugadas;

    public PanelInferior(PanelSuperior panelSuperior, InterfazLightsOut interfaz, PruebaTablero prueba) {
        this.interfaz = interfaz;
        this.panelSuperior = panelSuperior;

        JPanel paneLbl = new JPanel();
        this.setBackground(Color.WHITE);
        paneLbl.setBackground(Color.WHITE);
    
		paneLbl.setLayout(new GridLayout(1,4, 0, 10));

        JLabel nuevoB = new JLabel("Jugadas:");
		paneLbl.add(nuevoB);

        jugadas = new JLabel("0");
		paneLbl.add(jugadas);

        JLabel top10B = new JLabel("Jugador:");
		paneLbl.add(top10B);

        JLabel jugadorB = new JLabel("");
		paneLbl.add(jugadorB);

        this.add(paneLbl, BorderLayout.CENTER);
    }

    public void actualizarJugadas(int contador)
    {
        String contString = String.valueOf(contador);
        jugadas.setText(contString);
    }
}