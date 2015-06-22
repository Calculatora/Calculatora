package calculatora;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import superClass.Bloque;
import superClass.BloqueBotones;

public class Digitos extends BloqueBotones{

	private final int NUM_DIGITOS=12;
	
	protected Digitos() {
		super();
	}
	
	protected Digitos(Color color) {
		super(color);
		GridLayout LayoutBotones = new GridLayout(4,3);
		Botones = new Button[NUM_DIGITOS];
	}
}