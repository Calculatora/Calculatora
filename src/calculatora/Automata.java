package calculatora;

import javax.swing.JTextField;
/**
 * Realiza las funciones de los operandos y operadores.
 * @author Cristina Vila
 *
 */
public class Automata {
	private static final int LONG_DISPLAY = 16;
	private static JTextField Visor;
	private static Double Operando1 = (double) 0;
	private static Double Operando2 = (double) 0;
	private static char operador;
	private static byte estado;
	
	
	/**
	 * Constructor que inicializa el objeto.
	 * @param Visor
	 */
	public Automata(JTextField Visor) {
		this.Visor = Visor;
	}
	/**
	 * Procesa el mensaje introducido por el usuario.
	 * @param Car
	 * @throws OpcionErronea
	 */
	public static void CaracterIntroducido(char Car) throws OpcionErronea {
		System.out.println(Car);
		comprobarVisorValido();
		System.out.println("Antes de comprobar el estado:_"+estado);
		evolucionarEstado(Car);
		System.out.println("Despues de comprobar el estado:_"+estado);
		ejecutarEstado(Car);
		
		comprobarLongitud();
		System.out.println("Estado a la salida "+estado);
		
	}
	/**
	 * Ejecuta el mensaje que ha mandado el usuario,
	 * dependiendo del estado en el que se encuentre.
	 * @param Car
	 * @throws OpcionErronea
	 */
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
				addOperador(Car);
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
			case 13:
				operar();
				addOperador(Car);
				break;
			default:
				throw new OpcionErronea();
		}
	}
	/**
	 * Verifica si lo que ha introducido el usuario está completo.
	 */
	private static void comprobarVisorValido() {
		if (!Utilidades.comprobarNumeroComaOperador(Visor.getText())){
			Visor.setText("0");
		}
	}

	/**
	 * Cambia el estado cuando el usuario va introduciendo nuevos mensajes. 
	 * @param Car
	 * @throws OpcionErronea
	 */
	private static void evolucionarEstado(char Car) throws OpcionErronea{
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
		case 13:
			estado13(Car);
			break;
		}
	} 

	/**
	 * El método estado13 llamada al metodo estado 12.
	 * @param car
	 * @throws OpcionErronea
	 */
	private static void estado13(char car) throws OpcionErronea {
		estado = 6;
		estado6(car);
	}
	
	/**
	 * El método estado12 llama al método estadoo y cambia al estado 0 o 6.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado12(char car) throws OpcionErronea {
		if (Utilidades.comprobarOperador(car)){
			estado = 6;
		} else {
			estado = 0;
			estado0(car);
		}
	}
	/**
	 * El método estado11 llama al método estado10 y cambia al estado 10.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado11(char car) throws OpcionErronea {
		estado = 10;
		estado10(car);
	}
	/**
	 * El método estado10 llama al método estado9.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado10(char car) throws OpcionErronea {
		estado9(car);		
	}
	/**
	 * El método estado9 cambia al estado 10, 11, 12 o 13.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado9(char car) throws OpcionErronea {
		if (Utilidades.comprobarNumero(car)){
			estado = 10;
		} else if(Utilidades.comprobarOperador(car)){
			estado = 13;
		} else if (Utilidades.comparar(car,"=")){
			estado = 12;
		} else if (Utilidades.comparar(car,"±")){
			estado = 11;
		} else {
			throw new OpcionErronea();
		}
	}
	/**
	 * El método estado8 llama al método estado7 y cambia al estado 7.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado8(char car) throws OpcionErronea {
		estado = 7;
		estado7(car);
	}
	/**
	 * El método estado7 cambia al estado 8, 9 o 12.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado7(char car) throws OpcionErronea {
		if (Utilidades.comprobarNumero(car)){
			estado = 7;
		} else if (Utilidades.comparar(car,"=")){
			estado = 12;
		} else if (Utilidades.comprobarOperador(car)){
			estado = 13;
		} else if (Utilidades.comparar(car,".")){
			estado = 9;
		} else if (Utilidades.comparar(car,"±")){
			estado = 8;
		} else {
			throw new OpcionErronea();
		}		
	}
	/**
	 * El método estado6 cambia al estado 7, 8 o 9.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado6(char car) throws OpcionErronea {
		if (Utilidades.comprobarNumero(car)){
			estado = 7;
		} else if (Utilidades.comparar(car,"±")){
			estado = 8;
		} else if (Utilidades.comparar(car,".")){
			estado = 9;
		} /*else if (comprobarOperador(car)){
			estado = 6;
		}*/ else {
			throw new OpcionErronea();
		}
		Visor.setText("0");
	}
	/**
	 * El método estado5 llama al método estado4 y cambia al estado 4.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado5(char car) throws OpcionErronea {
		estado = 4;
		estado4(car);		
	}
	/**
	 * El estado4 llama al método estado3.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado4(char car) throws OpcionErronea {
		estado3(car);		
	}
	/**
	 * El método estado3 puede cambiar al estado 4, 5 o 6.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado3(char car) throws OpcionErronea {
		if (Utilidades.comprobarNumero(car)){
			estado = 4;
		} else if(Utilidades.comprobarOperador(car)){
			estado = 6;
		} else if (Utilidades.comparar(car,"±")){
			estado = 5;
		} else {
			throw new OpcionErronea();
		}
	}
	/**
	 * El método estado2 llama al método estado1 y cambia al estado 1.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado2(char car) throws OpcionErronea {
		estado = 1;
		estado1(car);
	}
	/**
	 * El estado1 cambia al estado 2, 3 o 6. 
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado1(char car) throws OpcionErronea {
		if (Utilidades.comprobarNumero(car)){
			estado = 1;
		} else if(Utilidades.comprobarOperador(car)){
			estado = 6;
		} else if (Utilidades.comparar(car,".")){
			estado = 3;
		} else if (Utilidades.comparar(car,"±")){
			estado = 2;
		} else {
			throw new OpcionErronea();
		}		
	}
	/**
	 * El estado0 cambia al estado 1, 2 o 3.
	 * @param car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void estado0(char car) throws OpcionErronea {
		if(Utilidades.comparar(car,"±")){
			estado = 2;
		} else if (Utilidades.comprobarNumero(car)){
			estado = 1;
		} else if (Utilidades.comparar(car, ".")) {
			estado = 3;
		} else {
			throw new OpcionErronea();
		}
		Visor.setText("0");
	}	

	/**
	 * Realiza la operación que le ha mandado el usuario.
	 * @throws OpcionErronea
	 */
	
	private static void operar() throws OpcionErronea {
		Operando2 = Double.parseDouble(Visor.getText());
		try{
			double resultado = obtenerResultado();
			Operando2 = resultado;
			System.out.println("==================================");
			System.out.println(resultado);
			System.out.println("==================================");
			/**if(String.valueOf(Operando2).equals("NaN")|| String.valueOf(Operando2).equals("Infinity") ){
				Visor.setText("Resultado indefinido");
			}*/
			Visor.setText(String.valueOf(Operando2));
		} catch (OpcionErronea e){
			Operando2 = 0d;
			Visor.setText(e.divCero());			
		}
	}
	
	/**
	 * Devuelve el resultado al usuario.
	 * @return
	 * @throws OpcionErronea
	 */
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
	
	/**
	 * 	Comprueba y ajusta al visor la longitud del número que devuelve.
	 */
	
	private static void comprobarLongitud() {
		if (Visor.getText().length() > LONG_DISPLAY ){
			if (Utilidades.compruebaNotacionCientifica(Visor.getText())){
				try {
					int posE = Visor.getText().indexOf("E");
					String primerFragmento = Visor.getText().substring(0,posE);
					String segundoFragmento = Visor.getText().substring(posE,Visor.getText().length());
					int longitudDebidaPrimerFragmento = LONG_DISPLAY - segundoFragmento.length();
					Visor.setText(primerFragmento.substring(0,longitudDebidaPrimerFragmento)+segundoFragmento);
				} catch (Exception e){
				}
				
			} else {
				Visor.setText(Visor.getText().substring(0,LONG_DISPLAY));
			}
		}
	}
	
	/**
	 * Añade operador.
	 * @param Car: caracter capturado desde ratón o teclado.
	 */
	private static void addOperador(char Car) {
//		System.out.println(Visor.getText());
//		if(!Utilidades.comprobarOperador(Car)){
			Operando1 = Double.parseDouble(Visor.getText());			
//		}	
		System.out.println("EN el visor: "+Visor.getText());
		System.out.println("Operando 1: "+Operando1);
		operador = Car;
		String resultado = String.valueOf(Car);
		Visor.setText(resultado);
	}
	
	/**
	 * Pone el signo negativo al número.
	 * @param display
	 * @return
	 */
	private static boolean esNegativo(String display){
		return display.charAt(0) == '-';
	}

	
	/**
	 * Cambia los números de signo en el visor.
	 */
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
	
	

	/**
	 * Añade el dígito al visor.
	 * @param Car: caracter capturado desde ratón o teclado.
	 * @throws OpcionErronea
	 */
	private static void addDigito(char Car) throws OpcionErronea {
		String cadena = String.valueOf(Car);
		boolean quitarCero = false;

		if (Visor.getText().equals("0")){
			quitarCero = true;
		}
		if (Utilidades.comprobarNumero(Car)){
			if(esNegativo(Visor.getText())&&Visor.getText().charAt(1)=='0'){
				Visor.setText("-"+cadena);	
			}
			else if(quitarCero){
				Visor.setText(cadena);
			} else {
				Visor.setText(Visor.getText()+cadena);
			}
		} else {
			throw new OpcionErronea();
		}
	}
	
	/**
	 * Añade coma al visor.
	 * @param Car: caracter capturado desde ratón o teclado.
	 */
	private static void addComa(char Car) {
		String cadena = String.valueOf(Car);
		boolean quitarCero = false;
		if (Visor.getText().equals("0") && !cadena.equals(".")){
			quitarCero = true;
		}
		if (Utilidades.comprobarNumeroComa(Car)){
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
	
	/**
	 * Establece el estado.
	 * @param est
	 */
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
	/**
	 * Devuelve el estado.
	 * @return
	 */
	public static int getEstado() {
		return estado;
	}
	
}