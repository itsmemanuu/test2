package uniandes.dpoo.taller4.Interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class prueba extends JFrame
{
	public prueba() {
		
		setLayout(new BorderLayout());
		
		//Centro
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(4,4,10,10));
		panelBotones.setBackground(Color.CYAN);
		panelBotones.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		
		//Arriba
		JTextField norte = new JTextField("Arriba");
		
		
		
		JButton botones[][] = new JButton[4][4];
		
//		for(int i=0; i<4; i++) {
//			for(int j=0; j<4; j++) {
//				botones[i][j] = new JButton(i);
//				panelBotones.add(botones[i][j]);
//				botones[i][j].addActionListener(this);
//			}
//		}
//		
//		add(panelBotones, BorderLayout.CENTER);
		add(norte, BorderLayout.NORTH);
		
		
		this.setTitle("Ventana");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		prueba prueba = new prueba();
		prueba.setVisible(true);
	}
	                                       
			
	
}
