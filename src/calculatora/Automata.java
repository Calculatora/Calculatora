package calculatora;

import java.awt.TextField;

public class Automata {
	private static byte Estado = 0; //Sin operacion, 1 suma, 2, resta, 3 multi, 4 division 
	private static TextField Visor;
	private static double Operando1=0d;
	private static double Operando2=0d;
	private static char Operador=' '; 
	
	public Automata(TextField Visor) {
		this.Visor = Visor;
	}
	
	public static void CaracterIntroducido(char Car) throws OpcionErronea {
		if (Visor.getText().equals("No valido")){
			Visor.setText("");
		}
		Visor.setText(Visor.getText()+Car);
		switch(Estado) {
			case 0:
				switch(Car) {
					case'+':
						Estado=1;
					break;
					case '-':
						Estado=2;
						break;
					case '*':
						Estado=3;
						break;
					case '/':
						Estado=4;
						break;
				}
				break;
			case 1:
				
				Visor.setText(Visor.getText()+Car);
				
			}
		
		
		
					
				//...
	
	}
	
	private static double ObtenerResultado() {
		switch(Operador) {
			case '+':
				return Operando1 + Operando2;
			case '-':
				return Operando1 - Operando2;
			case '*':
				return Operando1 * Operando2;
			case '/':
				return Operando1 / Operando2;
			default:
				return 0d;
		} 
	}
	
}