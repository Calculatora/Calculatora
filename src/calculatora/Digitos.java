package calculatora;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import superClass.Bloque;
import superClass.BloqueBotones;

public class Digitos extends BloqueBotones{

	private final int NUM_DIGITOS = 12;
	
	protected Digitos() {
		super();
	}
	
	protected Digitos(Color color) {
		super();
		GridLayout LayoutBotones = new GridLayout(4,3);
		MiPanel.setLayout(LayoutBotones);
		
		Botones = new Button[NUM_DIGITOS];
		
		
		
		Botones[0] = new Button("0");
		Botones[1] = new Button("1");
		Botones[2] = new Button("2");
		Botones[3] = new Button("3");
		Botones[4] = new Button("4");
		Botones[5] = new Button("5");
		Botones[6] = new Button("6");
		Botones[7] = new Button("7");
		Botones[8] = new Button("8");
		Botones[9] = new Button("9");
		Botones[10] = new Button(",");
		Botones[11] = new Button("=");
		
		for (int i = Botones.length - 1; i >= 0; i--){
			MiPanel.add(Botones[i]);
			Botones[i].addMouseListener(new ControlRaton());
			Botones[i].setBackground(color);
		}
		
		
	}
}