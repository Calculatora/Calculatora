package calculatora.superClass;

import java.awt.Button;
import java.awt.Color;

public class BloqueBotones  extends Bloque {
	protected Button[] Botones;
	
	protected BloqueBotones(){
		super();
	}
	
	public Button[] DameBotones(){
		return Botones;
	}
}
