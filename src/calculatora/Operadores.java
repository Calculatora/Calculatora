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
		super();
		GridLayout LayoutBotones = new GridLayout(NUM_BOTONES,0);
		MiPanel.setLayout(LayoutBotones);
		Botones = new Button[NUM_BOTONES];
		Botones[0] = new Button("+");
		Botones[1] = new Button("-");
		Botones[2] = new Button("*");
		Botones[3] = new Button("/");
		
		for (int i = 0; i < Botones.length; i++){
			MiPanel.add(Botones[i]);
			Botones[i].setBackground(color);
		}
	}
	
}