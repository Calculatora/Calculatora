package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;

import calculatora.Automata;
import calculatora.OpcionErronea;
import calculatora.paneles.Resultados;

/**
 * Utilizadas para las llamadas
 * Utilidades para las llamadas comunes de distintos controladores de eventos
 * al mismo m�todo
 * 
 * @author jfernandezpe
 * @since 2015/06/25
 *
 */
public class Llamadas {
	/**
	 * Metodo para llamar del evento al automata
	 * @param boton
	 */
	public static void llamoAutomata(Button boton){
		char Car = boton.getLabel().charAt(0);
		try { 
			Automata.CaracterIntroducido(Car); 
		} catch(OpcionErronea e) {
			Resultados.setText(e.mensajeError());
			boton.setBackground(Color.red);
		}
	}
}