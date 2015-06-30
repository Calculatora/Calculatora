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
		estado = 0;
		estado0(car);		
	}

	private static void estado11(char car) {
		estado = 10;
		estado10(car);
	}

	private static void estado10(char car) {
		estado9(car);		
	}

	private static void estado9(char car) {
		if (comprobarNumero(car)){
			estado = 10;
//		} else if(comprobarOperador(car)){
//			estado = 6;
		} else if (comparar(car,"±")){
			estado = 11;
		}
	}

	private static void estado8(char car) {
		estado = 7;
		estado7(car);
	}

	private static void estado7(char car) {
		if (comprobarNumero(car)){
			//
//		} else if(comprobarOperador(car)){
//			estado = 6;
		} else if (comparar(car,".")){
			estado = 9;
		} else if (comparar(car,"±")){
			estado = 8;
		}		
	}

	private static void estado6(char car) {
		if (comprobarNumero(car)){
			estado = 7;
		} else if (comparar(car,"±")){
			estado = 8;
		} else if (comparar(car,".")){
			estado = 9;
		}
	}

	private static void estado5(char car) {
		estado = 4;
		estado4(car);		
	}

	private static void estado4(char car) {
		estado3(car);		
	}

	private static void estado3(char car) {
		if (comprobarNumero(car)){
			estado = 4;
		} else if(comprobarOperador(car)){
			estado = 6;
		} else if (comparar(car,"±")){
			estado = 5;
		}
	}

	private static void estado2(char car) {
		estado = 1;
		estado1(car);
	}

	private static void estado1(char car) {
		if (comprobarNumero(car)){
			//
		} else if(comprobarOperador(car)){
			estado = 6;
		} else if (comparar(car,".")){
			estado = 3;
		} else if (comparar(car,"±")){
			estado = 2;
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
		
	}
	
	public static boolean comparar(char car, String text){
		String c = String.valueOf(car);
		return c.equals(text);
	}

	public class Estado{
		public Estado(){
			
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
			Operando2 = 0d;
			Resultados.setText(e.divCero());			
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
	
	public static boolean comprobarOperador(char Car){
		String cadena = String.valueOf(Car);
		return Pattern.matches("[+]|[-]|[*]|[/]", cadena);
	}

	
	private static void operador(char car) {
		operador = car;		
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