package calculatora.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;

import calculatora.superClass.BloqueBotones;
/**
 * Clase que pone dígitos (Números del 0 al 9, "," y "=") a los botones.
 * @author jfernandezpe
 *
 */
public class Digitos extends BloqueBotones{

	private final int NUM_DIGITOS = 12;
	
	/**
	 * Constructor que inicializa el objeto Digitos.
	 */
	protected Digitos() {
		super();
	}
	/**
	 * Constructor que inicializa el objeto Digisto indicando el color de los botones.
	 * @param color
	 */
	public Digitos(Color col) {
		super();
		color = col;
		GridLayout LayoutBotones = new GridLayout(4,3);
		MiPanel.setLayout(LayoutBotones);
		
		Botones = new JButton[NUM_DIGITOS];
		
		Botones[11] = new JButton("=");
		Botones[10] = new JButton(".");
		Botones[9] = new JButton("0");
		Botones[8] = new JButton("1");
		Botones[7] = new JButton("2");
		Botones[6] = new JButton("3");
		Botones[5] = new JButton("4");
		Botones[4] = new JButton("5");
		Botones[3] = new JButton("6");
		Botones[2] = new JButton("7");
		Botones[1] = new JButton("8");
		Botones[0] = new JButton("9");

		Font fuente=new Font("Dialog", Font.BOLD, 36);
		for (int i = Botones.length - 1; i >= 0; i--){
			MiPanel.add(Botones[i]);
			Botones[i].setPreferredSize(new Dimension(80, 80));
			Botones[i].setFont (fuente);	
		}
		
		configBotones();
	}
}