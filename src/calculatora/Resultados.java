package calculatora;

import java.awt.Color;
import java.awt.TextField;

import superClass.Bloque;

public class Resultados extends Bloque {

	static TextField resultado;
	
	protected Resultados() {
		super();
	}
	
	protected Resultados(Color color){
		super();
		resultado = new TextField("",12);
		resultado.setBackground(color);
		MiPanel.add(resultado);
		
	}
	
	public static TextField dameResultado(){
		return resultado;
	}

	public static  void setText(String texto) {
		resultado.setText(texto);		
	}
	
}
