package calculatora.superClass;

import java.awt.Button;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Color;

public abstract class Bloque {
	protected Panel MiPanel = new Panel();
	
	protected Bloque(){
	}
	
	public Panel DamePanel(){
		return MiPanel;		
	}
}