package calculatora.superClass;

import java.awt.Button;
import java.awt.Color;

import calculatora.paneles.Boton;

/**
 * Clase que pone el bloque de los dígitos y operadores en la interfaz.
 * @author Alumno mañana
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
	 * Método que devuelve un array.
	 * @return
	 */
	public Button[] DameBotones(){
		return Botones;
	}
}
