package calculatora.eventos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Clase que cierra la ventana de la calculadora.
 * @author Alumno mañana
 *
 */
public class ControlVentana extends WindowAdapter {
	public void windowClosing(WindowEvent EventoQueLlega){ 
		System.exit(0);
	}
}