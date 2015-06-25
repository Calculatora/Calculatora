package calculatora.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;

import calculatora.superClass.Bloque;

/**
 * Clase que pone el bloque de los resultados en la interfaz de la calculadora.
 * @author Alumno mañana
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
		resultado = new TextField("",15);
		resultado.setPreferredSize(new Dimension(350,20));
		resultado.setBackground(color);
		Font fuente=new Font("Dialog", Font.BOLD, 36);
		resultado.setFont (fuente);	
		MiPanel.add(resultado);	
	}
	
	/**
	 * Método para que devuelva el resultado.
	 * @return
	 */
	public static TextField dameResultado(){
		return resultado;
	}
	
	/**
	 * Método para poner el resultado.
	 * @param texto
	 */
	public static  void setText(String texto) {
		resultado.setText(texto);		
	}
	
}
