package uniandes.dpoo.taller4.Interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.*;
import java.awt.event.*;


public class PanelSuperior extends JPanel implements ItemListener, ActionListener{
	
	private JLabel size;
	private JComboBox<String> comboBox;
	private JLabel dificultad;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	private InterfazLightsOut interfaz;
	private int sizeTablero;
	private int dificultadTablero;
	
	/**
	 * @param interfaz
	 */
	public PanelSuperior(InterfazLightsOut interfaz) {
		this.interfaz = interfaz;
		
		this.size = new JLabel("Tamaño: ");
		size.setBorder(new LineBorder(Color.DARK_GRAY));
		
		this.comboBox = new JComboBox<String>();
		comboBox.setBounds(10,10,80,20);
		comboBox.addItem("3x3");
		comboBox.addItem("5x5");
		comboBox.addItem("8x8");
		comboBox.addItemListener(this);
		
		this.dificultad = new JLabel("Dificultad:");
		
		this.facil = new JRadioButton("Fácil");
		facil.setBounds(75,50,100,30);
		facil.addActionListener(this);
		
		this.medio = new JRadioButton("Medio");
		medio.setBounds(75,50,100,30);
		medio.addActionListener(this);
		
		this.dificil = new JRadioButton("Difícil");
		dificil.setBounds(75,50,100,30);
		dificil.addActionListener(this);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(facil);
		bg.add(medio);
		bg.add(dificil);
		
		setLayout(new FlowLayout());
		add(size);
		add(comboBox);
		add(dificultad);
		add(facil);
		add(medio);
		add(dificil);
		
		this.sizeTablero = 3;
		this.dificultadTablero = sizeTablero*sizeTablero/4;
	}

	public void actionPerformed(ActionEvent e) {
		
		if (facil.isSelected()) {
			this.dificultadTablero = sizeTablero*sizeTablero/4;
		}
		else if (medio.isSelected()) {
			this.dificultadTablero = sizeTablero*sizeTablero/3;
		}
		else if (dificil.isSelected()) {
			this.dificultadTablero = sizeTablero*sizeTablero/2;
		}
	}

	public  void itemStateChanged(ItemEvent e) {
        if (e.getSource()==comboBox) {
            String seleccionado=(String)comboBox.getSelectedItem();
			if (seleccionado.equals("3x3")) 
			{
				sizeTablero = 3;
				
        	}
			else if (seleccionado.equals("5x5"))
			{
				sizeTablero = 5;
				
			}
			else
			{
				sizeTablero = 8;
			}
		}
	}

    public int getSizeTablero() {
        return this.sizeTablero;
    }

	public int getDificultadTablero() {
		return this.dificultadTablero;
	}
}
