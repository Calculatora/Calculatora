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
 * Clase que controla la entrada de eventos a trav�s del rat�n.
 * @author Alumno ma�ana
 *
 */
public class ControlRaton extends MouseAdapter {
	
	/**
	 * M�todo para introducir caracteres por medio del rat�n.
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
	 * Cuando pasamos el rat�n por encima de los botones, �stos se cambian a color cyan.
	 */
	public void mouseEntered(MouseEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource();
		boton.setBackground(Color.CYAN);
	}
	/**
	 * Cuando quitamos el rat�n de encima de los botones, vuelven al color original.
	 */
	public void mouseExited(MouseEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource();
		boton.setBackground(boton.getColorOriginal());		
	}
}