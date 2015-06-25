package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import calculatora.Automata;
import calculatora.OpcionErronea;
import calculatora.paneles.Boton;
import calculatora.paneles.Resultados;

/**
 * Clase que controla la entrada de eventos a través del ratón.
 * @author Alumno mañana
 *
 */
public class ControlRaton extends MouseAdapter {
	
	/**
	 * Método para introducir caracteres por medio del ratón.
	 */
	
	public void mouseClicked(MouseEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource();
		char Car = boton.getLabel().charAt(0);
		System.out.print(Car);
		
		try { 
			Automata.CaracterIntroducido(Car); 
		} catch(OpcionErronea e) {
			Resultados.setText(e.getMessage());
			boton.setBackground(Color.red);
		}
	}
	/**
	 * Cuando pasamos el ratón por encima de los botones, éstos se cambian a color cyan.
	 */
	public void mouseEntered(MouseEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource();
		boton.setBackground(Color.CYAN);
	}
	/**
	 * Cuando quitamos el ratón de encima de los botones, vuelven al color original.
	 */
	public void mouseExited(MouseEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource();
		boton.setBackground(boton.getColorOriginal());		
	}
}