package calculatora;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import calculatora.eventos.ControlVentana;
import calculatora.paneles.Digitos;
import calculatora.paneles.Especiales;
import calculatora.paneles.Operadores;
import calculatora.paneles.Resultados;


public class GUICalculadora {
	public GUICalculadora() {
		JFrame MiMarco = new JFrame(); 
		Color colorDigitos = new Color(63,207,153);
		Color colorOperaciones = new Color(0,255,128);
		Color colorResultado = new Color(60,157,255);
		Color colorEspeciales = new Color(62,206,188);
		Digitos InstanciaDigitos = new Digitos(colorDigitos);
		Operadores InstanciaOperadores = new Operadores(colorOperaciones);
		Resultados InstanciaResultados = new Resultados(colorResultado);
		Especiales InstanciaEspeciales = new Especiales(colorEspeciales);
		
		JPanel PanelCentral = new JPanel();
		PanelCentral.add(InstanciaEspeciales.DamePanel());
		PanelCentral.add(InstanciaDigitos.DamePanel());
		PanelCentral.add(InstanciaOperadores.DamePanel());
		MiMarco.add(PanelCentral,"Center");
		MiMarco.add(InstanciaResultados.DamePanel(),"North");


		MiMarco.setSize(360,480);
		MiMarco.setTitle("Calculadora");  
		MiMarco.setVisible(true);
		MiMarco.setResizable(false);
		
		MiMarco.addWindowListener(new ControlVentana());
		
	} 
}
