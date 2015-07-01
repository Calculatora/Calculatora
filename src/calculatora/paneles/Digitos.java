package calculatora.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;

import calculatora.eventos.ControlFoco;
import calculatora.eventos.ControlRaton;
import calculatora.eventos.ControlTeclado;
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
	public Digitos(Color color) {
		super();
		GridLayout LayoutBotones = new GridLayout(4,3);
		MiPanel.setLayout(LayoutBotones);
		
		Botones = new JButton[NUM_DIGITOS];
		
		Botones[0] = new JButton("=");
		Botones[1] = new JButton(".");
		Botones[2] = new JButton("0");
		Botones[3] = new JButton("1");
		Botones[4] = new JButton("2");
		Botones[5] = new JButton("3");
		Botones[6] = new JButton("4");
		Botones[7] = new JButton("5");
		Botones[8] = new JButton("6");
		Botones[9] = new JButton("7");
		Botones[10] = new JButton("8");
		Botones[11] = new JButton("9");

		Font fuente=new Font("Dialog", Font.BOLD, 36);
		for (int i = Botones.length - 1; i >= 0; i--){
			MiPanel.add(Botones[i]);
			Botones[i].addMouseListener(new ControlRaton(color));
			Botones[i].addFocusListener(new ControlFoco(color));
			Botones[i].addKeyListener(new ControlTeclado());
			Botones[i].setBackground(color);
			Botones[i].setPreferredSize(new Dimension(80, 80));
			Botones[i].setFont (fuente);	
		}
	}
}