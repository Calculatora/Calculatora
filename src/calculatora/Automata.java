package calculatora;

import java.util.regex.Pattern;

import javax.swing.JTextField;

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
		ejecutarEstado(Car);
		comprobarLongitud();
		System.out.println("Estado a la salida "+estado);
		
	}

	private static void ejecutarEstado(char Car) throws OpcionErronea {
		switch(estado){ 
		//El case 0 no es necesario, nunca ocurrirá (si está en 0 se cambia a 1 en comprobar estado)
			case 1:
				addDigito(Car);
				break;
			case 2:
				cambiarSigno();
				break;
			case 3:
				addComa(Car);
				break;
			case 4:
				addDigito(Car);
				break;
			case 5:
				cambiarSigno();
				break;
			case 6:
				addOperacion(Car);
				break;
			case 7:
				addDigito(Car);
				break;
			case 8:
				cambiarSigno();
				break;
			case 9:
				addComa(Car);
				break;				
			case 10:
				addDigito(Car);
				break;
			case 11:
				cambiarSigno();
			case 12:
				operar();
				break;
			default:
				throw new OpcionErronea();
		}
	}

	private static void comprobarVisorValido() {
		if (!comprobarNumeroComaOperador(Visor.getText())){
			Visor.setText("0");
		}
		System.out.println("IMCOMPLETO");
	}


	private static void comprobarEstado(char Car) throws OpcionErronea{
		switch(estado){
		case 0:
			estado0(Car);
			break;
		case 1:
			estado1(Car);
			break;
		case 2:
			estado2(Car);
			break;
		case 3:
			estado3(Car);
			break;
		case 4:
			estado4(Car);
			break;
		case 5:
			estado5(Car);
			break;
		case 6:
			estado6(Car);
			break;
		case 7:
			estado7(Car);
			break;
		case 8:
			estado8(Car);
			break;
		case 9:
			estado9(Car);
			break;
		case 10:
			estado10(Car);
			break;
		case 11:
			estado11(Car);
			break;
		case 12:
			estado12(Car);
			break;
		}
	} 

	private static void estado12(char car) throws OpcionErronea {
		if (comprobarOperador(car)){
			estado = 6;
		} else {
			estado = 0;
			estado0(car);
		}
	}

	private static void estado11(char car) throws OpcionErronea {
		estado = 10;
		estado10(car);
	}

	private static void estado10(char car) throws OpcionErronea {
		estado9(car);		
	}

	private static void estado9(char car) throws OpcionErronea {
		if (comprobarNumero(car)){
			estado = 10;
		} else if(comprobarOperador(car)){
			estado = 13;
		} else if (comparar(car,"±")){
			estado = 11;
		} else {
			throw new OpcionErronea();
		}
	}

	private static void estado8(char car) throws OpcionErronea {
		estado = 7;
		estado7(car);
	}

	private static void estado7(char car) throws OpcionErronea {
		if (comprobarNumero(car)){
			//
		} else if(comprobarOperador(car)){
			estado = 6;
		} else if (comparar(car,"=")){
			estado = 12;
		} else if (comprobarOperador(car)){
			estado = 13;
		} else if (comparar(car,".")){
			estado = 9;
		} else if (comparar(car,"±")){
			estado = 8;
		} else {
			throw new OpcionErronea();
		}		
	}

	private static void estado6(char car) throws OpcionErronea {
		if (comprobarNumero(car)){
			estado = 7;
		} else if (comparar(car,"±")){
			estado = 8;
		} else if (comparar(car,".")){
			estado = 9;
		} else {
			throw new OpcionErronea();
		}
		Visor.setText("0");;
	}

	private static void estado5(char car) throws OpcionErronea {
		estado = 4;
		estado4(car);		
	}

	private static void estado4(char car) throws OpcionErronea {
		estado3(car);		
	}

	private static void estado3(char car) throws OpcionErronea {
		if (comprobarNumero(car)){
			estado = 4;
		} else if(comprobarOperador(car)){
			estado = 6;
		} else if (comparar(car,"±")){
			estado = 5;
		} else {
			throw new OpcionErronea();
		}
	}

	private static void estado2(char car) throws OpcionErronea {
		estado = 1;
		estado1(car);
	}

	private static void estado1(char car) throws OpcionErronea {
		if (comprobarNumero(car)){
			//
		} else if(comprobarOperador(car)){
			estado = 6;
		} else if (comparar(car,".")){
			estado = 3;
		} else if (comparar(car,"±")){
			estado = 2;
		} else {
			throw new OpcionErronea();
		}		
	}

	private static void estado0(char car) throws OpcionErronea {
		if(comparar(car,"±")){
			estado = 2;
		} else if (comprobarNumeroComa(car)){
			estado = 1;
		} else {
			throw new OpcionErronea();
		}
		Visor.setText("0");
	}
	
	private static boolean comparar(char car, String text){
		String c = String.valueOf(car);
		return c.equals(text);
	}
	
	
	
	
	
	
	private static void operar() throws OpcionErronea {
		Operando2 = Double.parseDouble(Visor.getText());
		try{
			double resultado = obtenerResultado();
			Operando2 = resultado;
			System.out.println("==================================");
			System.out.println(resultado);
			System.out.println("==================================");
			Visor.setText(String.valueOf(Operando2));
		} catch (OpcionErronea e){
			Operando2 = 0d;
			Visor.setText(e.divCero());			
		}
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
	
		
	
	private static void comprobarLongitud() {
		if (Visor.getText().length() > LONG_DISPLAY ){
			Visor.setText(Visor.getText().substring(0,LONG_DISPLAY));
		}
	}

	private static void addOperacion(char Car) {
		Operando1 = Double.parseDouble(Visor.getText());	
		System.out.println(Visor.getText());
		System.out.println("Operando 1: "+Operando1);
		operador = Car;
		String resultado = String.valueOf(Car);
		Visor.setText(resultado);
	}



	private static void cambiarSigno() {
		try {
			String aux = Visor.getText().substring(0,1);
			if (aux.equals("-")){
				aux = Visor.getText().substring(1, Visor.getText().length());
				Visor.setText(aux);		
			} else {
				Visor.setText("-"+Visor.getText());
			}
		} catch (StringIndexOutOfBoundsException e){
			Visor.setText("0");
		}
	}



	private static void addDigito(char Car) throws OpcionErronea {
		String cadena = String.valueOf(Car);
		boolean quitarCero = false;

		if (Visor.getText().equals("0")){
			quitarCero = true;
		}
		if (comprobarNumero(Car)){
			if(quitarCero){
				Visor.setText(cadena);
			} else {
				Visor.setText(Visor.getText()+cadena);
			}
		} else {
			throw new OpcionErronea();
		}
	}
	
	private static void addComa(char Car) {
		String cadena = String.valueOf(Car);
		boolean quitarCero = false;
		if (Visor.getText().equals("0") && !cadena.equals(".")){
			quitarCero = true;
		}
		if (comprobarNumeroComa(Car)){
			if(quitarCero){
				Visor.setText(cadena);
			} else {
				if (Visor.getText().equals("")){
					Visor.setText("0"+cadena);
				} else {
					Visor.setText(Visor.getText()+cadena);
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
	
	private static boolean comprobarOperador(char Car){
		String cadena = String.valueOf(Car);
		return Pattern.matches("[+]|[-]|[*]|[/]", cadena);
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