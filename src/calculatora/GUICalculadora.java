package calculatora;

import java.awt.*; 

import calculatora.paneles.Digitos;
import calculatora.paneles.Operadores;
import calculatora.paneles.Resultados;
public class GUICalculadora {
	public GUICalculadora() {
		Frame MiMarco = new Frame(); 
		Color colorDigitos = new Color(63,207,153);
		Color colorOperaciones = new Color(0,255,128);
		Color colorResultado = new Color(60,157,255);
		Digitos InstanciaDigitos = new Digitos(colorDigitos);
		Operadores InstanciaOperadores = new Operadores(colorOperaciones);
		Resultados InstanciaResultados = new Resultados(colorResultado);
		
		Panel panelCentral = new Panel();
		panelCentral.add(InstanciaDigitos.DamePanel());
		panelCentral.add(InstanciaOperadores.DamePanel());
		MiMarco.add(panelCentral,"Center");
		MiMarco.add(InstanciaResultados.DamePanel(),"North");


		MiMarco.setSize(360,435);
		MiMarco.setTitle("Calculadora");  
		MiMarco.setVisible(true);
//		MiMarco.setResizable(false);
	} 
}
