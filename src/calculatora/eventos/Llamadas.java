package calculatora.eventos;

import java.awt.Color;

import javax.swing.JButton;

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
	public static void llamoAutomata(JButton boton){
		String orden = boton.getText();
		if (orden.equals("CE")){
			AutomataEspecial.limpiarUltimoNumero();
		} else if (orden.equals("C")){
			AutomataEspecial.limpiarOperaciones();
		} else if (orden.equals("±")){
			llamadaAutomata(boton);
		} else if(orden.equals("M+")){
			AutomataEspecial.guardarMemoria();
		} else if (orden.equals("Mc")){
			AutomataEspecial.borrarMemoria();
		} else if (orden.equals("Mr")){
			AutomataEspecial.recuperarMemoria();
		} else { 
			llamadaAutomata(boton);
		}
		
	}
	
	private static void llamadaAutomata(JButton boton){
		char Car = boton.getText().charAt(0);
		try { 
			Automata.CaracterIntroducido(Car); 
		} catch(OpcionErronea e) {
			Resultados.setText(e.mensajeError());
			boton.setBackground(Color.red);
		}		
	}
}
