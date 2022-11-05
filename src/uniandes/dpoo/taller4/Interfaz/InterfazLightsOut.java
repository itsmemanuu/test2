package uniandes.dpoo.taller4.Interfaz;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;


import javax.swing.*;
import uniandes.dpoo.taller4.modelo.*;
import uniandes.dpoo.taller4.Interfaz.*;


public class InterfazLightsOut extends JFrame implements WindowListener
{

	private RegistroTop10 registro;
	private Tablero tablero;
	private Top10 top;
	
	private JPanel ventana;
	private JPanel panelJuego;
	private PanelSuperior panelSuperior;
	private boolean juegoIniciado;
	private PruebaTablero prueba;
	
	public InterfazLightsOut(RegistroTop10 registro, Tablero tablero, Top10 top) {
		
		ventana = new JPanel();
		this.setBackground(Color.WHITE);
		panelSuperior = new PanelSuperior(this);
		PanelInferior panelInferior = new PanelInferior(panelSuperior, this);
		
		ventana.setLayout(new BorderLayout());
		add(panelSuperior, BorderLayout.NORTH);
		add(panelInferior, BorderLayout.SOUTH);

		JPanel temp = new JPanel();
		temp.setBackground(Color.WHITE);

		add(temp, BorderLayout.CENTER);
		
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
		if (this.panelJuego != null)
		{
			remove(this.panelJuego);
		}
	}
	
	public static void main(String[] args) {
		
		InterfazLightsOut interfaz = new InterfazLightsOut(null, null, null);
		interfaz.setVisible(true);
		// addWindowListener(new WindowAdapter()
		// 	{
		// 		public void windowClosing(WindowEvent e)
		// 		{
		// 			salvarTop10();
		// 		}
		// 	});
	}

    public void agregarTablero(PruebaTablero prueba) {
		this.prueba = prueba;
		add(prueba, BorderLayout.CENTER);
    }

	public void eliminarTablero() {
		if (this.prueba != null)
		{
			remove(this.prueba);
		}
    }
	
	public JPanel getVentana() {
		return ventana;
	}

	public Top10 getTop() {
		return top;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
