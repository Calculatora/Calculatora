package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ControlFoco implements FocusListener {
	private Color ColorBoton;   
	ControlFoco(Color ColorBoton) {
		this.ColorBoton = ColorBoton;
	}
	public void focusGained(FocusEvent EventoQueLlega){
		Button Boton = (Button) EventoQueLlega.getSource(); 
		Boton.setBackground(Color.green);
	}
	public void focusLost(FocusEvent EventoQueLlega){
		Button Boton = (Button) EventoQueLlega.getSource
		(); 
		Boton.setBackground(ColorBoton); 
	}
}