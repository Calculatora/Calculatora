package calculatora.paneles;

import java.awt.Button;
import java.awt.Color;

public class Boton extends Button {
	private Color colorOriginal;
	
	Boton(){
		super();
	}
	
	Boton(String label){
		super(label);
	}
	
	public void setColorOriginal(Color col){
		colorOriginal = col;
	}
	
	public Color getColorOriginal(){
		return colorOriginal;
	}
}
