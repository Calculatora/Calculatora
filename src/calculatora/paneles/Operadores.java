package calculatora.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;

import calculatora.superClass.BloqueBotones;
/**
 * Clase que pone operadores ("+", "-", "*" y "/") a los botones.
 * @author jfernandezpe
 *
 */
public class Operadores extends BloqueBotones{
	private final int NUM_BOTONES = 4;
	
	/**
	 * Constructor que inicia el objeto operadores.
	 */
	protected Operadores() {
		super();
	}
	
	/**
	 * Constructor que inicia el objeto operadores con un color.
	 * @param color
	 */
	public Operadores(Color col) {
		super();
		color = col;
		GridLayout LayoutBotones = new GridLayout(NUM_BOTONES,1);
		MiPanel.setLayout(LayoutBotones);
		Botones = new JButton[NUM_BOTONES];
		Botones[0] = new JButton("+");
		Botones[1] = new JButton("-");
		Botones[2] = new JButton("*");
		Botones[3] = new JButton("/");
		
		Font fuente=new Font("Dialog", Font.BOLD, 36);

		for (int i = 0; i < Botones.length; i++){
			MiPanel.add(Botones[i]);
			Botones[i].setPreferredSize(new Dimension(80, 80));
			Botones[i].setFont (fuente);		
		}
		
		configBotones();
	}
	
}