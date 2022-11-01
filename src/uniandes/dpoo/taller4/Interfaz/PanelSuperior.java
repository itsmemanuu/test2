package uniandes.dpoo.taller4.Interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;


public class PanelSuperior extends JPanel implements ItemListener{
	
	private JLabel tamanio;
	private JComboBox<String> comboBox;
	private JLabel dificultad;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	
	public PanelSuperior() {
		
		this.tamanio = new JLabel("Tamaño: ");
		tamanio.setBorder(new LineBorder(Color.DARK_GRAY));
				
		this.comboBox = new JComboBox<String>();
		comboBox.setBounds(10,10,80,20);
		comboBox.addItem("3x3");
		comboBox.addItem("5x5");
		comboBox.addItem("8x8");
		comboBox.addItemListener(this);
		
		this.dificultad = new JLabel("Dificultad:");
		
		this.facil = new JRadioButton("Fácil");
		facil.setBounds(75,50,100,30);
		
		this.medio = new JRadioButton("Medio");
		medio.setBounds(75,50,100,30);
		
		this.dificil = new JRadioButton("Difícil");
		dificil.setBounds(75,50,100,30);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(facil);
		bg.add(medio);
		bg.add(dificil);
		
		setLayout(new FlowLayout());
		add(tamanio);
		add(comboBox);
		add(dificultad);
		add(facil);
		add(medio);
		add(dificil);
		

	}

	public  void itemStateChanged(ItemEvent e) {
        if (e.getSource()==comboBox) {
            String seleccionado=(String)comboBox.getSelectedItem();
			int x;
			if (seleccionado.equals("3x3")) 
			{
				x = 3;
				
        	}
			else if (seleccionado.equals("5x5"))
			{
				x = 5;
				
			}
			else
			{
				x = 8;
				
			}
			PanelJuego panelJuego = new PanelJuego(x);
			InterfazLightsOut.agregarPanel(panelJuego);
		}
	}
}
