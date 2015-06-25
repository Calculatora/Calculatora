package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;

import calculatora.Automata;
import calculatora.AutomataEspecial;
import calculatora.OpcionErronea;
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
	/**
	 * Metodo para llamar del evento al automata
	 * @param boton
	 */
	public static void llamoAutomata(Button boton){
		String orden = boton.getLabel();
		if (orden.equals("CE")){
			AutomataEspecial.limpiarUltimoNumero();
		} else if (orden.equals("C")){
			AutomataEspecial.limpiarOperaciones();
		} else if (orden.equals("±")){
			AutomataEspecial.cambiarSigno();
		} else if(orden.equals("M+")){
			AutomataEspecial.guardarMemoria();
		} else if (orden.equals("Mc")){
			AutomataEspecial.borrarMemoria();
		} else if (orden.equals("Mr")){
			AutomataEspecial.recuperarMemoria();
		} else { 
			char Car = boton.getLabel().charAt(0);

			try { 
				Automata.CaracterIntroducido(Car); 
			} catch(OpcionErronea e) {
				Resultados.setText(e.mensajeError());
				boton.setBackground(Color.red);
			}
		}
		
	}
}
