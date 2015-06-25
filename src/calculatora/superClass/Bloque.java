package calculatora.superClass;

import java.awt.Panel;

public abstract class Bloque {
	protected Panel MiPanel = new Panel();
	
	protected Bloque(){
	}
	
	public Panel DamePanel(){
		return MiPanel;		
	}
}