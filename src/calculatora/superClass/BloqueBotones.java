package calculatora.superClass;

import java.awt.Button;
import java.awt.Color;

import calculatora.paneles.Boton;

/**
 * Clase que pone el bloque de los d�gitos y operadores en la interfaz.
 * @author Alumno ma�ana
 *
 */
public class BloqueBotones  extends Bloque {
	protected Boton[] Botones;
	
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
