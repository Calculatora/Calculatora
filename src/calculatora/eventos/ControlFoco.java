package calculatora.eventos;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import calculatora.paneles.Boton;

public class ControlFoco implements FocusListener {
	public ControlFoco() {
	}
	public void focusGained(FocusEvent EventoQueLlega){
		Button Boton = (Button) EventoQueLlega.getSource(); 
		Boton.setBackground(Color.green);
	}
	public void focusLost(FocusEvent EventoQueLlega){
		Boton boton = (Boton) EventoQueLlega.getSource
		(); 
		boton.setBackground(boton.getColorOriginal()); 
	}
}