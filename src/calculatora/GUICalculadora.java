package calculatora;

import java.awt.*; 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import calculatora.eventos.ControlVentana;
import calculatora.paneles.Digitos;
import calculatora.paneles.Especiales;
import calculatora.paneles.Operadores;
import calculatora.paneles.Resultados;
public class GUICalculadora {
	public GUICalculadora() {
		Frame MiMarco = new Frame(); 
		Color colorDigitos = new Color(63,207,153);
		Color colorOperaciones = new Color(0,255,128);
		Color colorResultado = new Color(60,157,255);
		Color colorEspeciales = new Color(62,206,188);
		Digitos InstanciaDigitos = new Digitos(colorDigitos);
		Operadores InstanciaOperadores = new Operadores(colorOperaciones);
		Resultados InstanciaResultados = new Resultados(colorResultado);
		Especiales InstanciaEspeciales = new Especiales(colorEspeciales);
		
		Panel panelCentral = new Panel();
		panelCentral.add(InstanciaEspeciales.DamePanel());
		panelCentral.add(InstanciaDigitos.DamePanel());
		panelCentral.add(InstanciaOperadores.DamePanel());
		MiMarco.add(panelCentral,"Center");
		MiMarco.add(InstanciaResultados.DamePanel(),"North");


		MiMarco.setSize(360,480);
		MiMarco.setTitle("Calculadora");  
		MiMarco.setVisible(true);
		MiMarco.setResizable(false);
		
		MiMarco.addWindowListener(new ControlVentana());
		
	} 
}
