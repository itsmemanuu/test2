package uniandes.dpoo.taller4.Interfaz;
import uniandes.dpoo.taller4.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;

public class PanelIzq extends JPanel implements ItemListener, ActionListener{

    int sizeTablero;
    private Tablero tablero;
    private boolean[][] tableroActual;
    private PanelSuperior panelSuperior;
    private InterfazLightsOut interfaz;
    private PanelInferior panelInferior;

    public PanelIzq(PanelSuperior panelSuperior, InterfazLightsOut interfaz, PanelInferior panelInferior) {
        this.interfaz = interfaz;
        this.panelSuperior = panelSuperior;
        this.panelInferior = panelInferior;
        this.setBackground(Color.WHITE);

        JPanel paneBotones = new JPanel();
        paneBotones.setBackground(Color.WHITE);
		paneBotones.setLayout(new GridLayout(4,1, 100, 100));

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
        if (e.getActionCommand().equals("Nuevo") && (sizeTablero != 0)) {
            panelInferior.actualizarJugadas(0);
            interfaz.eliminarTablero();
            this.tablero = new Tablero(sizeTablero);
            this.tableroActual = tablero.darTablero();
            this.desordenar();
            PruebaTablero prueba = new PruebaTablero(tableroActual, tablero, panelInferior, interfaz.getTop());
            interfaz.agregarTablero(prueba);
            revalidate();
            repaint();
		}
		else if (e.getActionCommand().equals("Reiniciar") && tablero != null && tableroActual != null) {
            interfaz.eliminarTablero();
            this.tablero.reiniciar();
            tableroActual = tablero.darTablero();
            PruebaTablero prueba = new PruebaTablero(tableroActual, tablero, panelInferior, interfaz.getTop());
            interfaz.agregarTablero(prueba);
            revalidate();
            repaint();
		}
        
		else if (e.getActionCommand().equals("Top 10"))  {
						DialogTop10();
		}
	}
    
    
    public void DialogTop10() {
    	
    	JFrame f = interfaz.getF();
 		JDialog d = new JDialog(f,"TOP 10", true);
 		d.setLayout(new BorderLayout());
 		DefaultListModel<String> l1 = new DefaultListModel<>();
 		Collection<RegistroTop10> collection = interfaz.getTop().darRegistros();
 		if (collection != null) {
	 		
	 		for (RegistroTop10 s: collection) {
	 			
	 			if (s == null) {
	 				l1.addElement("XXX ---");
	 			} else {
	 				l1.addElement(s.toString());
	 			}
	 		}
 		} else {
 			l1.addElement("XXX ---");
 		}
 		JList<String> list = new JList<>(l1);
 		list.setFont(new Font("Courier",Font.BOLD, 16));
 		d.add(list, BorderLayout.CENTER);
 		d.setSize(400,400);
 		d.setVisible(true);
 		
 		
 		
 		
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

    public void desordenar()
    {
        if (tablero.tableroIluminado())
        {
            tablero.desordenar(panelSuperior.getDificultadTablero());
            desordenar();
        }
    }

}
