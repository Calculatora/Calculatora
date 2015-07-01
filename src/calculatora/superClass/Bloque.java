package calculatora.superClass;

import javax.swing.JPanel;

/**
 * Clase que pone el bloque del panel de resultados en la interfaz.
 * @author jfernandezpe
 *
 */
public abstract class Bloque {
	protected JPanel MiPanel = new JPanel();
	
	/**
	 * Constructor que inicializa el objeto Bloque.
	 */
	protected Bloque(){
	}
	
	/**
	 * Método que devuelve el panel.
	 * @return
	 */
	public JPanel DamePanel(){
		return MiPanel;		
	}
}