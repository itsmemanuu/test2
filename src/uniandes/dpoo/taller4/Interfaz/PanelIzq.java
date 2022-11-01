package uniandes.dpoo.taller4.Interfaz;
import uniandes.dpoo.taller4.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.*;
import java.awt.event.*;

public class PanelIzq extends JPanel implements ItemListener, ActionListener{

    int sizeTablero = 3;
    private Tablero tablero;
    private boolean[][] tableroActual;
    private PanelSuperior panelSuperior;
    private InterfazLightsOut interfaz;

    public PanelIzq(PanelSuperior panelSuperior, InterfazLightsOut interfaz) {
        this.interfaz = interfaz;
        this.panelSuperior = panelSuperior;

        JPanel paneBotones = new JPanel();
		paneBotones.setLayout(new GridLayout(4,1, 10, 10));

        JButton nuevoB = new JButton("Nuevo");
		paneBotones.add(nuevoB);
		nuevoB.addActionListener(this);

        JButton reiniciarB = new JButton("Reiniciar");
		paneBotones.add(reiniciarB);
		reiniciarB.addActionListener(this);

        JButton top10B = new JButton("Top 10");
		paneBotones.add(top10B);
		top10B.addActionListener(this);

        JButton jugadorB = new JButton("Cambiar Jugador");
		paneBotones.add(jugadorB);
		jugadorB.addActionListener(this);

        this.add(paneBotones, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.sizeTablero = panelSuperior.getSizeTablero();
        if (e.getActionCommand().equals("Nuevo")) {
            Tablero tablero = new Tablero(sizeTablero);
            tableroActual = tablero.darTablero();
			PanelJuego panelJuego = new PanelJuego(sizeTablero, tableroActual);
			interfaz.agregarPanel(panelJuego);
            repaint();
		}
		else if (e.getActionCommand().equals("Reiniciar") && tableroActual != null) {
            this.tablero.reiniciar();
            tableroActual = tablero.darTablero();
			System.out.println("Reiniciar");
			PanelJuego panelJuego = new PanelJuego(sizeTablero, tableroActual);
			interfaz.agregarPanel(panelJuego);
            repaint();
		}
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    
}
