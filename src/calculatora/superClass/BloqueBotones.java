package calculatora.superClass;

import java.awt.Button;

/**
 * Clase que pone el bloque de los dígitos y operadores en la interfaz.
 * @author jfernandezpe
 *
 */
public class BloqueBotones  extends Bloque {
	protected Button[] Botones;
	
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
	public Button[] DameBotones(){
		return Botones;
	}
}
