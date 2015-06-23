package calculatora.superClass;

import java.awt.Button;
import java.awt.Color;

import calculatora.paneles.Boton;

public class BloqueBotones  extends Bloque {
	protected Boton[] Botones;
	
	protected BloqueBotones(){
		super();
	}
	
	public Button[] DameBotones(){
		return Botones;
	}
}
