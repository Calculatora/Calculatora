package calculatora.eventos;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * Clase que controla la entrada de eventos a trav�s del rat�n.
 * @author cristinavi
 *
 */
public class ControlRaton extends MouseAdapter {
	
	private Color colorOriginal;
	
	public ControlRaton(Color color){
		colorOriginal = color;
	}
	/**
	 * M�todo para introducir caracteres por medio del rat�n.
	 */
	public void mouseClicked(MouseEvent EventoQueLlega){
		JButton boton = (JButton) EventoQueLlega.getSource();
		Llamadas.llamoAutomata(boton);
	}
	/**
	 * Cuando pasamos el rat�n por encima de los botones, �stos se cambian a color cyan.
	 */
	public void mouseEntered(MouseEvent EventoQueLlega){
		JButton boton = (JButton) EventoQueLlega.getSource();
		boton.setBackground(Color.CYAN);
	}
	/**
	 * Cuando quitamos el rat�n de encima de los botones, vuelven al color original.
	 */
	public void mouseExited(MouseEvent EventoQueLlega){
		JButton boton = (JButton) EventoQueLlega.getSource();
		boton.setBackground(colorOriginal);		
	}
}