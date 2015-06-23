package calculatora.eventos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControlVentana extends WindowAdapter {
	public void windowClosing(WindowEvent EventoQueLlega){ 
		System.exit(0);
	}
}