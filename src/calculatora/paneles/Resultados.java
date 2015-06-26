package calculatora.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;

import calculatora.superClass.Bloque;

/**
 * Clase que pone el bloque de los resultados en la interfaz de la calculadora.
 * @author jfernandezpe
 *
 */
public class Resultados extends Bloque {

	static TextField resultado;
	
	/**
	 * Constructor que inicializa el objeto Resultados.
	 */
	protected Resultados() {
		super();
	}
	/**
	 * Constructor sobrecargado.
	 * @param color
	 */
	public Resultados(Color color){
		super();
		resultado = new TextField("0",15);
		resultado.setPreferredSize(new Dimension(350,20));
		resultado.setBackground(color);
		Font fuente=new Font("Dialog", Font.BOLD, 36);
		resultado.setFont (fuente);	
		resultado.setEditable(false);
		resultado.setEnabled(false); 
		MiPanel.add(resultado);	
	}
	
	/**
	 * Método para que devuelva el campo resultado.
	 * @return
	 */
	public static TextField dameCampoResultado(){
		return resultado;
	}
	
	/**
	 * Devuelve el resultado del campo de resultado
	 * @return
	 */
	public static String dameResultado(){
		return resultado.getText();
	}
	
	/**
	 * Método para poner el resultado.
	 * @param texto
	 */
	public static  void setText(String texto) {
		resultado.setText(texto);		
	}
	
}
