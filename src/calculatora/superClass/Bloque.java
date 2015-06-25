package calculatora.superClass;

import java.awt.Button;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Color;

/**
 * Clase que pone el bloque del panel de resultados en la interfaz.
 * @author Alumno ma�ana
 *
 */
public abstract class Bloque {
	protected Panel MiPanel = new Panel();
	
	/**
	 * Constructor que inicializa el objeto Bloque.
	 */
	protected Bloque(){
	}
	
	/**
	 * M�todo que devuelve el panel.
	 * @return
	 */
	public Panel DamePanel(){
		return MiPanel;		
	}
}