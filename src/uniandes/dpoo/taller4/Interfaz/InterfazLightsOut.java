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
	private JPanel panelJuego;
	private PanelSuperior panelSuperior;
	private boolean juegoIniciado;
	
	public InterfazLightsOut(RegistroTop10 registro, Tablero tablero, Top10 top) {
		
		ventana = new JPanel();
		panelSuperior = new PanelSuperior(this);
		
		ventana.setLayout(new BorderLayout());
		add(panelSuperior, BorderLayout.NORTH);
		
		
		this.setSize(700, 600);
		this.setTitle("LightsOut");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.juegoIniciado = false;

		PanelIzq botonesPanel = new PanelIzq(panelSuperior, this);
		add(botonesPanel, BorderLayout.EAST);

		

	}
	
	public void agregarPanel(JPanel panelJuego) {
		this.panelJuego = panelJuego;
		add(panelJuego, BorderLayout.CENTER);
	}

	public void eliminarPanel() {
		remove(this.panelJuego);
	}
	
	public static void main(String[] args) {
		
		InterfazLightsOut interfaz = new InterfazLightsOut(null, null, null);
		interfaz.setVisible(true);
	}

    public void agregarTablero(PruebaTablero prueba) {
		add(prueba, BorderLayout.CENTER);
    }
}
