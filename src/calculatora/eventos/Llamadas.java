package calculatora.eventos;

import java.awt.Color;
import java.awt.Event;

import calculatora.Automata;
import calculatora.OpcionErronea;
import calculatora.paneles.Boton;
import calculatora.paneles.Resultados;

/**
 * Utilizadas para las llamadas
 * Utilidades para las llamadas comunes de distintos controladores de eventos
 * al mismo método
 * 
 * @author jfernandezpe
 * @since 2015/06/25
 *
 */
public class Llamadas {
	public static void llamoAutomata(Boton boton){
		char Car = boton.getLabel().charAt(0);
		try { 
			Automata.CaracterIntroducido(Car); 
		} catch(OpcionErronea e) {
			Resultados.setText(e.mensajeError());
			boton.setBackground(Color.red);
		}
	}
}
