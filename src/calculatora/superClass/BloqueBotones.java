package calculatora.superClass;

import java.awt.Color;

import javax.swing.JButton;

import calculatora.eventos.ControlFoco;
import calculatora.eventos.ControlRaton;
import calculatora.eventos.ControlTeclado;


/**
 * Clase que pone el bloque de los dígitos y operadores en la interfaz.
 * @author jfernandezpe
 *
 */
public class BloqueBotones  extends Bloque {
	protected JButton[] Botones;
	protected Color color;
	
	/**
	 * Constructor que inicializa el objeto BloqueBotones.
	 */
	protected BloqueBotones(){
		super();
	}
	
	/**
	 * Método que devuelve un array.
	 * @return
	 */
	public JButton[] DameBotones(){
		return Botones;
	}
	
	/**
	 * Pone el foco sobre el elemento y lo pinta de rojo.
	 * @param car
	 */
	public void PonerFocoRojo(char car) {
		String text = String.valueOf(car);
		for (int i = 0; i < Botones.length; i++){
			if (Botones[i].getText().equals(text)){
				Botones[i].requestFocus();
				Botones[i].setBackground(Color.RED);
			}
		}		
	}
	
	/**
	 * Pone el foco sobre el elemento
	 * @param car
	 */
	public void ponerFoco(char car){
		String text = String.valueOf(car);
		for (int i = 0; i < Botones.length; i++){
			if (Botones[i].getText().equals(text)){
				Botones[i].requestFocus();;
			}
		}
	}
	
	/**
	 * Configura los botones
	 */
	public void configBotones(){
		for (int i = 0; i < Botones.length; i++){
			MiPanel.add(Botones[i]);
			Botones[i].addMouseListener(new ControlRaton(color));
			Botones[i].addFocusListener(new ControlFoco(color));
			Botones[i].addKeyListener(new ControlTeclado());
			Botones[i].setBackground(color);
		}
	}
}
