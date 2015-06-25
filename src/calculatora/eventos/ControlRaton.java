package calculatora.eventos;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import calculatora.paneles.Boton;

public class ControlRaton extends MouseAdapter {
	public void mouseClicked(MouseEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource();
		Llamadas.llamoAutomata(boton);
	}
	public void mouseEntered(MouseEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource();
		boton.setBackground(Color.CYAN);
	}
	
	public void mouseExited(MouseEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource();
		boton.setBackground(boton.getColorOriginal());		
	}
}