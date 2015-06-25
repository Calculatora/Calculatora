package calculatora.paneles;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Color;

import calculatora.eventos.ControlFoco;
import calculatora.eventos.ControlRaton;
import calculatora.superClass.BloqueBotones;

public class Operadores extends BloqueBotones{
	private final int NUM_BOTONES = 4;
	
	protected Operadores() {
		super();
	}
	
	public Operadores(Color color) {
		super();
		GridLayout LayoutBotones = new GridLayout(NUM_BOTONES,1);
		MiPanel.setLayout(LayoutBotones);
		Botones = new Boton[NUM_BOTONES];
		Botones[0] = new Boton("+");
		Botones[1] = new Boton("-");
		Botones[2] = new Boton("*");
		Botones[3] = new Boton("/");
		
		Font fuente=new Font("Dialog", Font.BOLD, 36);

		for (int i = 0; i < Botones.length; i++){
			MiPanel.add(Botones[i]);
			Botones[i].addMouseListener(new ControlRaton());
			Botones[i].addFocusListener(new ControlFoco());
			Botones[i].setBackground(color);
			Botones[i].setColorOriginal(color);
			Botones[i].setPreferredSize(new Dimension(80, 80));
			Botones[i].setFont (fuente);		
		}
	}
	
}