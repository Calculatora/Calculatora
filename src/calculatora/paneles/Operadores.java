package calculatora.paneles;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import calculatora.eventos.ControlFoco;
import calculatora.eventos.ControlRaton;
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
	public Operadores(Color color) {
		super();
		GridLayout LayoutBotones = new GridLayout(NUM_BOTONES,1);
		MiPanel.setLayout(LayoutBotones);
		Botones = new Button[NUM_BOTONES];
		Botones[0] = new Button("+");
		Botones[1] = new Button("-");
		Botones[2] = new Button("*");
		Botones[3] = new Button("/");
		
		Font fuente=new Font("Dialog", Font.BOLD, 36);

		for (int i = 0; i < Botones.length; i++){
			MiPanel.add(Botones[i]);
			Botones[i].addMouseListener(new ControlRaton(color));
			Botones[i].addFocusListener(new ControlFoco(color));
			Botones[i].setBackground(color);
			Botones[i].setPreferredSize(new Dimension(80, 80));
			Botones[i].setFont (fuente);		
		}
	}
	
}