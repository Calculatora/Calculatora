package calculatora.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;

import calculatora.superClass.Bloque;

public class Resultados extends Bloque {

	static TextField resultado;
	
	protected Resultados() {
		super();
	}
	
	public Resultados(Color color){
		super();
		resultado = new TextField("0",15);
		resultado.setPreferredSize(new Dimension(350,20));
		resultado.setBackground(color);
		resultado.setEditable(false);
		resultado.setEnabled(false); 
		Font fuente=new Font("Dialog", Font.BOLD, 36);
		resultado.setFont (fuente);	
		MiPanel.add(resultado);	
	}
	
	public static TextField dameResultado(){
		return resultado;
	}

	public static  void setText(String texto) {
		resultado.setText(texto);		
	}
	
}
