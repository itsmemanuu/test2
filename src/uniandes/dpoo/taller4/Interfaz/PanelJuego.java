package uniandes.dpoo.taller4.Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.*;

public class PanelJuego extends JPanel{


    public PanelJuego(int size, Tablero principal, InterfazLightsOut interfaz) {
        boolean[][] tableroActual = principal.darTablero();
        JPanel prueba = (JPanel)new PruebaTablero(tableroActual, principal);
        this.add(prueba, BorderLayout.CENTER);
        
    }
}
