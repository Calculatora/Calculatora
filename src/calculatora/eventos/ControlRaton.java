package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que controla la entrada de eventos a través del ratón.
 * @author cristinavi
 *
 */
public class ControlRaton extends MouseAdapter {
	
	private Color colorOriginal;
	
	public ControlRaton(Color color){
		colorOriginal = color;
	}
	/**
	 * Método para introducir caracteres por medio del ratón.
	 */
	public void mouseClicked(MouseEvent EventoQueLlega){
		Button boton = (Button) EventoQueLlega.getSource();
		Llamadas.llamoAutomata(boton);
	}
	/**
	 * Cuando pasamos el ratón por encima de los botones, éstos se cambian a color cyan.
	 */
	public void mouseEntered(MouseEvent EventoQueLlega){
		Button boton = (Button) EventoQueLlega.getSource();
		boton.setBackground(Color.CYAN);
	}
	/**
	 * Cuando quitamos el ratón de encima de los botones, vuelven al color original.
	 */
	public void mouseExited(MouseEvent EventoQueLlega){
		Button boton = (Button) EventoQueLlega.getSource();
		boton.setBackground(colorOriginal);		
	}
}