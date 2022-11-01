package uniandes.dpoo.taller4.Interfaz;
import java.awt.*;
import javax.swing.*;
import uniandes.dpoo.taller4.modelo.*;
import uniandes.dpoo.taller4.Interfaz.*;

public class InterfazLightsOut extends JFrame
{

	private RegistroTop10 registro;
	private Tablero tablero;
	private Top10 top;
	
	private JPanel ventana;
	private PanelJuego panelJuego;
	private PanelSuperior panelSuperior;
	
	public InterfazLightsOut(RegistroTop10 registro, Tablero tablero, Top10 top) {
		
		ventana = new JPanel();
		panelSuperior = new PanelSuperior();
		panelJuego = new PanelJuego(3);
		
		ventana.setLayout(new BorderLayout());
		add(panelSuperior, BorderLayout.NORTH);
		add(panelJuego, BorderLayout.WEST);
		
		
		
		
		this.setSize(700, 600);
		this.setTitle("LightsOut");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void agregarPanel(JPanel panelJuego) {
		add(panelJuego, BorderLayout.WEST);
	}
	
	public static void main(String[] args) {
		
		InterfazLightsOut interfaz = new InterfazLightsOut(null, null, null);
		interfaz.setVisible(true);
	}
}
