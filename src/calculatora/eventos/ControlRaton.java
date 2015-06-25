package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import calculatora.Automata;
import calculatora.OpcionErronea;
import calculatora.paneles.Boton;
import calculatora.paneles.Resultados;

public class ControlRaton extends MouseAdapter {
	public void mouseClicked(MouseEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource();
		char Car = boton.getLabel().charAt(0);
		System.out.print(Car);
		try { 
			Automata.CaracterIntroducido(Car); 
		} catch(OpcionErronea e) {
			Resultados.setText(e.mensajeError());
			boton.setBackground(Color.red);
		}
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