package calculatora.superClass;

import java.awt.Color;

import javax.swing.JButton;


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

	public void PonerRojo(char car) {
		String text = String.valueOf(car);
		for (int i = 0; i < Botones.length; i++){
			if (Botones[i].getText().equals(text)){
				Botones[i].setBackground(Color.RED);
			}
		}		
	}

	public void quitarRojo() {
		for (int i = 0; i < Botones.length; i++){
			Botones[i].setBackground(color);
		}	
	}
}
