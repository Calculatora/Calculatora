package calculatora.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;

import calculatora.superClass.BloqueBotones;
/**
 * Bloque de botones especiales
 * @author jfernandezpe
 *
 */
public class Especiales extends BloqueBotones{
	
	private final int NUM_BOTONES = 6;

	/**
	 * Constructor.
	 */
	public Especiales(){
		super();
	}
	
	/**
	 * Constructor.
	 * @param col
	 */
	public Especiales(Color col){
		super();
		color = col;
		GridLayout LayoutBotones = new GridLayout(1,4);
		MiPanel.setLayout(LayoutBotones);
		
		Botones = new JButton[NUM_BOTONES];
		
		Botones[0] = new JButton("CE");
		Botones[1] = new JButton("C");
		Botones[2] = new JButton("±");
		Botones[3] = new JButton("M+");
		Botones[4] = new JButton("Mc");
		Botones[5] = new JButton("Mr");

		Font fuente=new Font("Dialog", Font.BOLD, 14);
		
		for (int i = 0; i < Botones.length; i++){
			Botones[i].setPreferredSize(new Dimension(55, 55));
			Botones[i].setFont (fuente);
		}
		
		configBotones();
		
	}
}
