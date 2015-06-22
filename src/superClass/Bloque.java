package superClass;

import java.awt.Button;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Color;

public abstract class Bloque {
	private Panel MiPanel = new Panel();
	
	protected Bloque(){
		
	}
	
	protected Bloque(Color ColorBotones) {
		GridLayout LayoutBotones = new GridLayout(4,3);
	}
	
	public Panel DamePanel(){
		return MiPanel;		
	}
}