package calculatora;

import java.awt.TextField;

public class Automata {
	private static byte Estado = 0; 
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
		/*
		 * A partir del Estado 0.
		 */
			case 0:
				switch(Car) {
				/*
				 * Cambia a Estado 1 si es un "+,-,* o /".
				 */
					case '-':
					case '+':
					case '*':
					case '/':
						Estado=1;
							Visor.setText(Visor.getText()+Car);
						break;
				/*
				 * Cambia a estado Estado 2 si es un numero.
				 */
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=2;
						Visor.setText(Visor.getText()+Car); 
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					
					}
					break;
		/*
		 * A partir del Estado 1.
		 */
			case 1:
				switch(Car) {
				/*
				 * Cambia el operador y se mantiene en estado 1.
				 */
					case '-':
					case '+':
					case '*':
					case '/':
						Estado=1;
						String aux = new String();
						aux = Visor.getText().substring(0, 0);
						Visor.setText(aux+Car);
						break;
				/*
				 * Cambia a estado Estado 2 si es numero.
				 */	
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=2;
						Visor.setText(Visor.getText()+Car); 
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;
		/*
		 * A partir del estado 2
		 */
			case 2:
				switch(Car) {
				/*
				 * Cambia a estado Estado 2 si es igual.
				 */
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=2;
						Visor.setText(Visor.getText()+Car); 
						break;
				/*
				 * Pasa al estado 5 si es un operador.
				 */
					case '-':
					case '+':
					case '*':
					case '/':
						Estado=5;
							Visor.setText(Visor.getText()+Car);
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;
			/*
			 * A partir del estado 3
			 */
			case 3:
				switch(Car) {
				/*
				 * Cambia a estado Estado 4 si digito.
				 */
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=4;
						Visor.setText(Visor.getText()+Car); 
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;
		/*
		 * A partir del estado 4
		 */
			case 4:
				switch(Car) {
				/*
				 * Cambia a estado Estado 4 si digito.
				 */
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=4;
						Visor.setText(Visor.getText()+Car); 
						break;
				/*
				 * Cambia a estado Estado 5 si es operador.
				 */
					case '-':
					case '+':
					case '*':
					case '/':
						Estado=5;
							Visor.setText(Visor.getText()+Car);
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;
		/*
		 * A partir del estado 5
		 */
			case 5:
				switch(Car) {
				/*
				 * Cambia a estado Estado 7 si digito.
				 */
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=7;
						Visor.setText(Visor.getText()+Car); 
						break;
					/*
					 * Cambia a estado Estado 6 si ponemos "-" (num. negativo).
					 */
					case '-':
						Estado=6;
						Visor.setText(Visor.getText()+Car);
						break;
				/*
				 * Controlamos que se sobreescriba la operacion (verificar funcionamiento).
				 */
					case '+':
					case '*':
					case '/':
						Estado=5;
						String aux = new String();
						aux = Visor.getText().substring(0, 0);
						Visor.setText(aux+Car);
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;						
		/*
		 * A partir del estado 6
		 */
			case 6:
				switch(Car) {
				/*
				 * Cambia a estado Estado 7 si digito.
				 */
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=7;
						Visor.setText(Visor.getText()+Car); 
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;
					
		/*
		 * A partir del estado 7
		 */
			case 7:
				switch(Car) {
				/*
				 * Cambia a estado Estado 7 si digito.
				 */
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=7;
						Visor.setText(Visor.getText()+Car); 
						break;
					case ',':
						Estado=8;
						Visor.setText(Visor.getText()+Car); 
						break;
					case '=':
						Estado=10;
						Visor.setText(Visor.getText()+Car); 
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;
		/*
		 * A partir del estado 8
		 */
			case 8:
				switch(Car) {
				/*
				 * Cambia a estado Estado 9 si digito.
				 */
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=9;
						Visor.setText(Visor.getText()+Car); 
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;
		/*
		 * A partir del estado 9
		 */
			case 9:
				switch(Car) {
				/*
				 * Cambia a estado Estado 9 si digito.
				 */
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						Estado=9;
						Visor.setText(Visor.getText()+Car); 
						break;
					case '=':
						Estado=10;
						Visor.setText(Visor.getText()+Car); 
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;
		/*
		 * A partir del estado 10
		 */
			case 10:
				/*
				 * Hacemos la operacion y dejamos en la pantalla el resultado solamente
				 */
				procResult(Visor.getText());
				switch(Car) {
				/*
				 * Cambia a estado Estado 5 si es operador.
				 */
					case '-':
					case '+':
					case '*':
					case '/':
						Estado=5;
							Visor.setText(Visor.getText()+Car);
						break;
					default:
						//Lanzar();
						throw new OpcionErronea();
					}
					break;	
		}	
	}
	
	private static void procResult(String texto){
		
		char[] arrayResult = Visor.getText().toCharArray();
		int i = 0;
		while(arrayResult[i] != '+' || arrayResult[i] != '-'|| arrayResult[i] != '*'|| arrayResult[i] != '/' ){
			Operando1 = (double)arrayResult[i];
			i++;
		}
		System.out.println(Operando1);
		
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