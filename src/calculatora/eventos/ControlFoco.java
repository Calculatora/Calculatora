package calculatora.eventos;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

/**
 * Clase que controla el foco sobre los botones de la calculadora.
 * Implementa la interfaz FocusListener.
 * @author jfernandezpe
 *
 */
public class ControlFoco implements FocusListener {
	private Color colorOriginal;
	/**
	 * M�todo constructor para inicializar el objeto.
	 */
	public ControlFoco(Color color) {
		colorOriginal = color;
	}

	/**
	 * M�todo que establece color verde en un bot�n cuando ponemos el foco sobre �l.
	 */
	public void focusGained(FocusEvent EventoQueLlega){
		JButton boton = (JButton) EventoQueLlega.getSource(); 
		if (boton.getBackground() != Color.RED) {
			boton.setBackground(Color.green);
		}
	}
	/**
	 * Cuando sacamos el foco del bot�n vuelve al color original.
	 */
	public void focusLost(FocusEvent EventoQueLlega){
		JButton boton = (JButton) EventoQueLlega.getSource		(); 
		boton.setBackground(colorOriginal); 
	}
}