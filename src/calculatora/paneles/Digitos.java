package calculatora.paneles;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import calculatora.eventos.ControlFoco;
import calculatora.eventos.ControlRaton;
import calculatora.superClass.Bloque;
import calculatora.superClass.BloqueBotones;
/**
 * Clase que pone dígitos (Números del 0 al 9, "," y "=") a los botones.
 * @author Alumno mañana
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
	 * Constructor sobrecargado.
	 * @param color
	 */
	public Digitos(Color color) {
		super();
		GridLayout LayoutBotones = new GridLayout(4,3);
		MiPanel.setLayout(LayoutBotones);
		
		Botones = new Boton[NUM_DIGITOS];
		
		
		
		Botones[0] = new Boton("0");
		Botones[1] = new Boton("1");
		Botones[2] = new Boton("2");
		Botones[3] = new Boton("3");
		Botones[4] = new Boton("4");
		Botones[5] = new Boton("5");
		Botones[6] = new Boton("6");
		Botones[7] = new Boton("7");
		Botones[8] = new Boton("8");
		Botones[9] = new Boton("9");
		Botones[10] = new Boton(",");
		Botones[11] = new Boton("=");

		Font fuente=new Font("Dialog", Font.BOLD, 36);
		
		for (int i = Botones.length - 1; i >= 0; i--){
			MiPanel.add(Botones[i]);
			Botones[i].addMouseListener(new ControlRaton());
			Botones[i].addFocusListener(new ControlFoco());
			Botones[i].setBackground(color);
			Botones[i].setColorOriginal(color);
			Botones[i].setPreferredSize(new Dimension(80, 80));
			Botones[i].setFont (fuente);				
		}
		
		
	}
}