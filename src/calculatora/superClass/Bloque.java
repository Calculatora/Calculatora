package calculatora.superClass;

import java.awt.Panel;

/**
 * Clase que pone el bloque del panel de resultados en la interfaz.
 * @author Alumno mañana
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
	 * Método que devuelve el panel.
	 * @return
	 */
	public Panel DamePanel(){
		return MiPanel;		
	}
}