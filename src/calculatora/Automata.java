package calculatora;

import java.util.regex.Pattern;

import javax.swing.JTextField;

import calculatora.paneles.Resultados;

public class Automata {
	private static final int LONG_DISPLAY = 16;
	private static JTextField Visor;
	private static Double Operando1 = (double) 0;
	private static Double Operando2 = (double) 0;
	private static char operador;
	private static byte estado;
	
	
	
	public Automata(JTextField Visor) {
		this.Visor = Visor;
	}
	
	public static void CaracterIntroducido(char Car) throws OpcionErronea {
		System.out.println(Car);
		comprobarVisorValido();
		System.out.println("Antes de comprobar el estado:_"+estado);
		comprobarEstado(Car);
		System.out.println("Despues de comprobar el estado:_"+estado);
		switch(estado){ 
		//El case 0 no es necesario, nunca ocurrirá (si está en 0 se cambia a 1 en comprobar estado)

			case 1:
				addDigito(Car);//Tiene que comprobar el dígito y añadirlo
				break;
			case 2:
				cambiarSigno();
				estado = 1;
				break;
			case 3:
				addComa(Car);
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
				estado = 7;
				break;
			case 9:
				addComa(Car);
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
				break;
			case 13:
				addOperacion(Car);
				break;
			default:
				throw new OpcionErronea();
		}
		comprobarLongitud();
		System.out.println("Estado a la salida "+estado);
		
	}

	private static void comprobarVisorValido() {
		if (!comprobarNumeroComaOperador(Visor.getText())){
			Visor.setText("0");
		}
	}

	private static void comprobarLongitud() {
		if (Visor.getText().length() > LONG_DISPLAY ){
			Visor.setText(Visor.getText().substring(0,LONG_DISPLAY));
		}
	}

	private static void operar() throws OpcionErronea {
		Operando2 = Double.parseDouble(Resultados.dameResultado());
		Operando1 = Operando2;
		try{
			double resultado = obtenerResultado();
			Operando2 = resultado;
			Resultados.setText(String.valueOf(Operando2));
		} catch (OpcionErronea e){
			System.out.println("entro en catch");
			Operando2 = 0d;
			Resultados.setText(e.divCero());			
		}
		System.out.println("SACAR TRYCATCH AQUI");
	}


	private static void addOperacion(char Car){
		Operando1 = Operando2;
		Operando2 = Double.parseDouble(Resultados.dameResultado());
		operador = Car;
		String resultado = String.valueOf(Car);
		Resultados.setText(resultado);
	}

	private static void addOperacionPrimera(char Car) {
		Operando1 = Double.parseDouble(Resultados.dameResultado());	
		operador = Car;
		String resultado = String.valueOf(Car);
		Resultados.setText(resultado);
	}



	private static void cambiarSigno() {
		try {
			String aux = Resultados.dameResultado().substring(0,1);
			System.out.println("AUX"+aux);
			if (aux.equals("-")){
				aux = Resultados.dameResultado().substring(1, Resultados.dameResultado().length());
				Resultados.setText(aux);		
			} else {
				Resultados.setText("-"+Resultados.dameResultado());
			}
		} catch (StringIndexOutOfBoundsException e){
			Resultados.setText("0");
		}
	}



	private static void addDigito(char Car) throws OpcionErronea {
		String cadena = String.valueOf(Car);
		System.out.println("CADENA "+cadena);
		boolean quitarCero = false;

		if (Resultados.dameResultado().equals("0")){
			quitarCero = true;
		}
		if (comprobarNumero(Car)){
			if(quitarCero){
				Resultados.setText(cadena);
			} else {
				Resultados.setText(Resultados.dameResultado()+cadena);
			}
		} else {
			throw new OpcionErronea();
		}
	}
	
	private static void addComa(char Car) {
		String cadena = String.valueOf(Car);
		System.out.println("CADENA "+cadena);
		boolean quitarCero = false;
		if (Resultados.dameResultado().equals("0") && !cadena.equals(".")){
			quitarCero = true;
		}
		if (comprobarNumeroComa(Car)){
			if(quitarCero){
				Resultados.setText(cadena);
			} else {
				if (Resultados.dameResultado().equals("")){
					Resultados.setText("0"+cadena);
				} else {
					Resultados.setText(Resultados.dameResultado()+cadena);
				}
			}
		}
	}

	private static boolean comprobarNumeroComaOperador(String cadena){
		return Pattern.matches("([-]|)[0-9]+[.][0-9]+|([-]|)[0-9]+[.]|([-]|)[0-9]+|[+]|[-]|[*]|[/]", cadena);		
	}
	private static boolean comprobarNumeroComa(char Car){
		String cadena = String.valueOf(Car);		
		return Pattern.matches("[.]|[0-9]", cadena);
	}

	private static boolean comprobarNumero(char Car){
		String cadena = String.valueOf(Car);		
		return Pattern.matches("[0-9]", cadena);
	}

	private static void comprobarEstado(char Car){
		String aux = String.valueOf(Car);
		if (estado == 6 /*&& !aux.equals(".") && !aux.equals("±")*/) {
			estado = 7;
			Resultados.setText("");
		}
		if ( comprobarNumero(Car) ){
			if (estado == 0 || estado == 12){
				estado = 1;
			} else if (estado == 13){
				estado = 7;
				Resultados.setText("");
			}
		} else {
			switch(Car){
				case '+':
				case '-':
				case '*':
				case '/':
					if (estado == 1 || estado == 4 || estado == 10) {
						estado = 6;
						operador(Car);
					} else if (estado == 12){
						estado = 13;
						operador(Car);
					}
					break;
				case '.':
					switch(estado){
						case 1:
							estado = 3;
							break;
						case 7:
							estado = 9;
							break;
//						case
					}
					break;
				case '=':
					if (estado == 7 || estado == 10){
						estado = 12;
					}
					break;
				case '±':
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
	
	private static double obtenerResultado() throws OpcionErronea {
		double resultado;
		
		switch(operador) {
			case '+':
				resultado =  Operando1 + Operando2;
				break;
			case '-':
				resultado = Operando1 - Operando2;
				break;
			case '*':
				resultado = Operando1 * Operando2;
				break;
			case '/':
				try{
					resultado = Operando1 / Operando2;
				} catch (Exception e){
					System.out.println("Division erronea");
					throw new OpcionErronea();
				}
				break;
			default:
				resultado = 0;					
		}
		return resultado;
	}
	
	public static void setEstado(byte est){
		if (est == -1) {
			if (estado == 4){
				estado = 1;
			} else if (estado == 10){
				estado = 7;
			}
		} else {
			estado = est;
		}
	}

	public static int getEstado() {
		return estado;
	}
	
}