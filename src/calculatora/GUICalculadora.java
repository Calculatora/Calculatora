package calculatora;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import calculatora.eventos.ControlTeclado;
import calculatora.eventos.ControlVentana;
import calculatora.paneles.Digitos;
import calculatora.paneles.Especiales;
import calculatora.paneles.Operadores;
import calculatora.paneles.Resultados;
import calculatora.superClass.BloqueBotones;

/**
 * Establece la interfaz del programa.
 * @author Cristina Vila.
 *
 */
public class GUICalculadora {
	/**
	 * Constructor que inicializa el objeto.
	 */
	public GUICalculadora() {
		JFrame MiMarco = new JFrame(); 
		Color colorDigitos = new Color(213,249,235);
		Color colorOperaciones = new Color(154,216,239);
		Color colorResultado = new Color(60,157,255);
		Color colorEspeciales = new Color(128,234,232);
		BloqueBotones InstanciaDigitos = new Digitos(colorDigitos);
		BloqueBotones InstanciaOperadores = new Operadores(colorOperaciones);
		Resultados InstanciaResultados = new Resultados(colorResultado);
		BloqueBotones InstanciaEspeciales = new Especiales(colorEspeciales);
		
		JPanel PanelCentral = new JPanel();
		PanelCentral.add(InstanciaEspeciales.DamePanel());
		PanelCentral.add(InstanciaDigitos.DamePanel());
		PanelCentral.add(InstanciaOperadores.DamePanel());
		MiMarco.add(PanelCentral,"Center");
		MiMarco.add(InstanciaResultados.DamePanel(),"North");
		MiMarco.addKeyListener(new ControlTeclado(InstanciaDigitos,InstanciaOperadores,InstanciaEspeciales));

		MiMarco.setSize(360,480);
		MiMarco.setTitle("Calculatora");  
		MiMarco.setVisible(true);
		MiMarco.setResizable(false);
		
		MiMarco.addWindowListener(new ControlVentana());
		
	} 
}
