package superClass;

import java.awt.Button;
import java.awt.Color;

public class BloqueBotones  extends Bloque{
	protected Button[] Botones;
	
	protected BloqueBotones(){
		super();
	}
	
	protected BloqueBotones(Color color){
		super(color);
	}
	
	public Button[] DameBotones(){
		return Botones;
	}
}
