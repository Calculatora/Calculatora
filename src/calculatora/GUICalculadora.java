package calculatora;

import java.awt.*; 
public class GUICalculadora {
	public GUICalculadora() {
		Frame MiMarco = new Frame(); 
		Panel MiPanel = new Panel();
		BorderLayout PuntosCardinales = new BorderLayout();
		MiPanel.setLayout(PuntosCardinales);
		Color colorDigitos = Color.RED;
		Color colorOperaciones = Color.GREEN;
		Color colorResultado = Color.YELLOW;
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
