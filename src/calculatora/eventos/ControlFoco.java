package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ControlFoco implements FocusListener {
	private Color colorOriginal;
	
	public ControlFoco(Color color) {
		colorOriginal = color;
	}
	public void focusGained(FocusEvent EventoQueLlega){
		Button boton = (Button) EventoQueLlega.getSource(); 
		boton.setBackground(Color.green);
	}
	public void focusLost(FocusEvent EventoQueLlega){
		Button boton = (Button) EventoQueLlega.getSource
		(); 
		boton.setBackground(colorOriginal); 
	}
}