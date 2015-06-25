package calculatora.paneles;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import calculatora.eventos.ControlFoco;
import calculatora.eventos.ControlRaton;
import calculatora.eventos.ControlTeclado;
import calculatora.superClass.BloqueBotones;

public class Especiales extends BloqueBotones{
	
	private final int NUM_BOTONES = 6;

	
	public Especiales(){
		super();
	}
	
	public Especiales(Color color){
		super();
		GridLayout LayoutBotones = new GridLayout(1,4);
		MiPanel.setLayout(LayoutBotones);
		
		Botones = new Button[NUM_BOTONES];
		
		Botones[0] = new Button("CE");
		Botones[1] = new Button("C");
		Botones[2] = new Button("±");
		Botones[3] = new Button("M+");
		Botones[4] = new Button("Mc");
		Botones[5] = new Button("Mr");

		Font fuente=new Font("Dialog", Font.BOLD, 24);
		
		for (int i = 0; i < Botones.length; i++){
			MiPanel.add(Botones[i]);
			Botones[i].addMouseListener(new ControlRaton(color));
			Botones[i].addFocusListener(new ControlFoco(color));
			Botones[i].addKeyListener(new ControlTeclado());
			Botones[i].setBackground(color);
			Botones[i].setPreferredSize(new Dimension(55, 55));
			Botones[i].setFont (fuente);				
		}
		
	}
}
