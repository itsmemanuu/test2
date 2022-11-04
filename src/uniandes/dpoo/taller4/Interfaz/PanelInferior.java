package uniandes.dpoo.taller4.Interfaz;
import uniandes.dpoo.taller4.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.*;
import java.awt.event.*;

public class PanelInferior extends JPanel implements ItemListener, ActionListener{
    int sizeTablero;
    private Tablero tablero;
    private boolean[][] tableroActual;
    private PanelSuperior panelSuperior;
    private InterfazLightsOut interfaz;

    public PanelInferior(PanelSuperior panelSuperior, InterfazLightsOut interfaz) {
        this.interfaz = interfaz;
        this.panelSuperior = panelSuperior;

        JPanel paneBotones = new JPanel();
		paneBotones.setLayout(new GridLayout(1,4, 0, 10));

        JLabel nuevoB = new JLabel("Jugadas:");
		paneBotones.add(nuevoB);

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
        if (e.getActionCommand().equals("Nuevo") && (sizeTablero != 0)) {
            interfaz.eliminarTablero();
            this.tablero = new Tablero(sizeTablero);
            this.tableroActual = tablero.darTablero();
            tablero.desordenar(panelSuperior.getDificultadTablero());
            PruebaTablero prueba = new PruebaTablero(tableroActual, tablero);
            interfaz.agregarTablero(prueba);
            revalidate();
            repaint();
		}
		else if (e.getActionCommand().equals("Reiniciar") && tablero != null && tableroActual != null) {
            interfaz.eliminarTablero();
            this.tablero.reiniciar();
            tableroActual = tablero.darTablero();
            PruebaTablero prueba = new PruebaTablero(tableroActual, tablero);
            interfaz.agregarTablero(prueba);
            revalidate();
            repaint();
		}
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
    }
    
    /**
     * @return Tablero return the tablero
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * @param tablero the tablero to set
     */
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * @return boolean[][] return the tableroActual
     */
    public boolean[][] getTableroActual() {
        return tableroActual;
    }

    /**
     * @param tableroActual the tableroActual to set
     */
    public void setTableroActual(boolean[][] tableroActual) {
        this.tableroActual = tableroActual;
    }

    /**
     * @return PanelSuperior return the panelSuperior
     */
    public PanelSuperior getPanelSuperior() {
        return panelSuperior;
    }

    /**
     * @param panelSuperior the panelSuperior to set
     */
    public void setPanelSuperior(PanelSuperior panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    /**
     * @return InterfazLightsOut return the interfaz
     */
    public InterfazLightsOut getInterfaz() {
        return interfaz;
    }

    /**
     * @param interfaz the interfaz to set
     */
    public void setInterfaz(InterfazLightsOut interfaz) {
        this.interfaz = interfaz;
    }
}