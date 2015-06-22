package calculatora;

import java.awt.TextField;

public class Automata {
	private static byte Estado=0;
	private static TextField Visor;
	private static double Operando1=0d;
	private static double Operando2=0d;
	private static char Operador=' '; 
	
	Automata(TextField Visor) {
		this.Visor = Visor;
	}
	
	public static void CaracterIntroducido(char Car) throws OpcionErronea {
		if (Visor.getText().equals("No valido"))
			Visor.setText("");
		
		switch(Estado) {
			case 0:
				switch(Car) {
				case '-':
					Estado=1;
					Visor.setText(Visor.getText()+Car);
					break;
				}
				break;
		}
					
				//...
	
	}
	
	private static double ObtenerResultado() {
		switch(Operador) {
			case '+':
				return Operando1+Operando2;
			case '-':
				return Operando1 - Operando2;
			case '*':
				return Operando1*Operando2;
			case '/':
				return Operando1/Operando2;
			default:
				return 0d;
		} 
	}
	
}