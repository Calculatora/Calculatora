package calculatora.superClass;

import javax.swing.JButton;


/**
 * Clase que pone el bloque de los d�gitos y operadores en la interfaz.
 * @author jfernandezpe
 *
 */
public class BloqueBotones  extends Bloque {
	protected JButton[] Botones;
	
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
	public JButton[] DameBotones(){
		return Botones;
	}
}
