package calculatora;

import java.util.regex.Pattern;

import javax.swing.JTextField;

import calculatora.paneles.Resultados;

public class Automata {
	private static JTextField Visor;
	private static String Operando1 = "0";
	private static String Operando2 = "0";
	private static char operador;
	private static byte estado;
	
	
	
	public Automata(JTextField Visor) {
		this.Visor = Visor;
	}
	
	public static void CaracterIntroducido(char Car) throws OpcionErronea {
		System.out.println(Car);
//		if (Visor.getText().equals("No valido")){
//			Visor.setText("");
//		}
		System.out.println("Antes de comprobar el estado:_"+estado);
		comprobarEstado(Car);
		System.out.println("Despues de comprobar el estado:_"+estado);
		switch(estado){ 
		//El case 0 no es necesario, nunca ocurrir� (si est� en 0 se cambia a 1 en comprobar estado)
			case 1:
				addDigito(Car);//Tiene que comprobar el d�gito y a�adirlo
				break;
			case 2:
				cambiarSigno();
				estado = 1;
				break;
			case 3:
				addDigito(Car);
				estado = 4;
				break;
			case 4:
				addDigito(Car);
				break;
			case 5:
				cambiarSigno();
				estado = 4;
				break;
			case 6:
				addOperacionPrimera(Car);
				break;
			case 7:
				addDigito(Car);
				break;
			case 8:
				cambiarSigno();
				break;
			case 9:
				addDigito(Car);
				estado = 10;
				break;				
			case 10:
				addDigito(Car);
				break;
			case 11:
				cambiarSigno();
				estado = 10;
			case 12:
				operar();
				estado = 6;
				break;
			case 13:
				addOperacion(Car);
				estado = 6;
				break;
		}
		
		
	}
	
	private static void operar() {
		Operando2 = Resultados.dameResultado();
		double resultado = obtenerResultado();
		Operando1 = Operando2;
		Operando2 = String.valueOf(resultado);
		System.out.println("Operandos despu�s de operar "+Operando1+"_"+Operando2);
		Resultados.setText(String.valueOf(Operando2));
	}


	private static void addOperacion(char Car){
		System.out.println("Lo que hay en pantalla "+Resultados.dameResultado());
		Operando1 = Resultados.dameResultado();	
		operador = Car;
		String resultado = String.valueOf(Car);
		Resultados.setText(resultado);
		System.out.println("A�ado operacion"+Operando1+"_"+Operando2);
	}

	private static void addOperacionPrimera(char Car) {
		addOperacion(Car);
	}



	private static void cambiarSigno() {
		String aux = Resultados.dameResultado().substring(0,0);
		if (aux.equals('-')){
			aux = Resultados.dameResultado().substring(1, Resultados.dameResultado().length());
			Resultados.setText(aux);		
		} else {
			Resultados.setText("-"+Resultados.dameResultado());
		}
	}



	private static void addDigito(char Car) {
		System.out.println("aadDigito"+Car);
		String cadena = String.valueOf(Car);
		boolean quitarCero = false;
		if (Resultados.dameResultado().equals("0") && !cadena.equals(".")){
			quitarCero = true;
		}
		if (comprobarNumeroOComa(Car)){
			if(quitarCero){
				Resultados.setText(cadena);
			} else {
				Resultados.setText(Resultados.dameResultado()+Car);
			}
		}
		
	}

	private static boolean comprobarNumeroOComa(char Car){
		String cadena = String.valueOf(Car);		
		return Pattern.matches("[0-9]|-]", cadena);
	}

	private static void comprobarEstado(char Car){
		if (estado == 6) {
			estado = 7;
			Resultados.setText("");
		}
		if ( comprobarNumeroOComa(Car) ){
			if (estado == 0){
				estado = 1;
			}
		} else {
			switch(Car){
				case '+':
				case '-':
				case '*':
				case '/':
					if (estado == 1 || estado == 4 || estado == 7 || estado == 10) {
						estado = 6;
					} else if (estado == 12){
						estado = 13;
					}
					operador(Car);
					break;
				case '.':
					switch(estado){
					case 1:
						estado = 3;
						break;
					case 7:
						estado = 9;
						break;
					}
					break;
				case '=':
					if (estado == 7 || estado == 10){
						estado = 12;
					}
					break;
				case '�':
					switch(estado){
						case 1:
							estado = 2;
							break;
						case 4:
							estado = 5;
							break;
						case 7:
							estado = 8;
							break;
						case 10:
							estado = 11;
							break;
					}
					break;
			}
		}
	}
	
	private static void operador(char car) {
		operador = car;		
	}
	
	private static double obtenerResultado() {
		System.out.println(Operando1+"___"+Operando2);
		double ope1 = Integer.parseInt(Operando1);
		double ope2 = Integer.parseInt(Operando2);
		double resultado;
		
		switch(operador) {
			case '+':
				resultado =  ope1 + ope2;
				break;
			case '-':
				resultado = ope1 - ope2;
				break;
			case '*':
				resultado = ope1 * ope2;
				break;
			case '/':
				resultado = ope1 / ope2;
				break;
			default:
				resultado = 0;					
		}
		return resultado;
	}
	
}