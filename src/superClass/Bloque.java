package superClass;

import java.awt.Button;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Color;

public abstract class Bloque {
	protected Panel MiPanel = new Panel();
	
	protected Bloque(){
		GridLayout LayoutBotones = new GridLayout(4,3);
	}
	
	public Panel DamePanel(){
		return MiPanel;		
	}
}