package calculatora.superClass;

import java.awt.Button;

/**
 * Clase que pone el bloque de los d�gitos y operadores en la interfaz.
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
	 * M�todo que devuelve un array.
	 * @return
	 */
	public Button[] DameBotones(){
		return Botones;
	}
}
