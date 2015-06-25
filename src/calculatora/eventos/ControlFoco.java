package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import calculatora.paneles.Boton;

/**
 * Clase que controla el foco sobre los botones de la calculadora.
 * Implementa la interfaz FocusListener.
 * @author Alumno mañana
 *
 */
public class ControlFoco implements FocusListener {
	private Color ColorBoton;
	
	/**
	 * Método constructor para inicializar el objeto.
	 */
	public ControlFoco() {
	}
	/**
	 * Método que establece color verde en un botón cuando ponemos el foco sobre él.
	 */
	public void focusGained(FocusEvent EventoQueLlega){
		Button Boton = (Button) EventoQueLlega.getSource(); 
		Boton.setBackground(Color.green);
	}
	/**
	 * Cuando sacamos el foco del botón vuelve al color original.
	 */
	public void focusLost(FocusEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource
		(); 
		boton.setBackground(boton.getColorOriginal()); 
	}
}