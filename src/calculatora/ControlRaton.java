package calculatora;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlRaton extends MouseAdapter {
	public void mouseClicked(MouseEvent EventoQueLlega){
		Button Boton = (Button) EventoQueLlega.getSource();
		char Car = Boton.getLabel().charAt(0);
		System.out.print(Car);
		try { 
			Automata.CaracterIntroducido(Car); 
		} catch(OpcionErronea e) {
			Resultados.setText(e.getMessage());
			Boton.setBackground(Color.red);
		}
	}
	public void mouseEntered(MouseEvent EventoQueLlega){
	}
	
	public void mouseExited(MouseEvent EventoQueLlega){
		
	}
}