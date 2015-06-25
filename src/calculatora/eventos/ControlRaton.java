package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlRaton extends MouseAdapter {
	
	private Color colorOriginal;
	
	public ControlRaton(Color color){
		colorOriginal = color;
	}
	
	public void mouseClicked(MouseEvent EventoQueLlega){
		Button boton = (Button) EventoQueLlega.getSource();
		Llamadas.llamoAutomata(boton);
	}
	public void mouseEntered(MouseEvent EventoQueLlega){
		Button boton = (Button) EventoQueLlega.getSource();
		boton.setBackground(Color.CYAN);
	}
	
	public void mouseExited(MouseEvent EventoQueLlega){
		Button boton = (Button) EventoQueLlega.getSource();
		boton.setBackground(colorOriginal);		
	}
}