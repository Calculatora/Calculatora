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
		
		MiMarco.add(InstanciaDigitos.DamePanel(),"Center");
		MiMarco.add(InstanciaOperadores.DamePanel(),"East");
		MiMarco.add(InstanciaResultados.DamePanel(),"North");


		MiMarco.setSize(150,150);
		MiMarco.setTitle("Calculadora");  
		MiMarco.setVisible(true);
	} 
}
