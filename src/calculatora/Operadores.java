package calculatora;

import java.awt.Button;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Color;

import superClass.BloqueBotones;

public class Operadores extends BloqueBotones{
	private final int NUM_BOTONES = 4;
	
	protected Operadores() {
		super();
	}
	
	protected Operadores(Color color) {
		super(color);
		GridLayout LayoutBotones = new GridLayout(4,3);
		Botones = new Button[NUM_BOTONES];
	}
	
}