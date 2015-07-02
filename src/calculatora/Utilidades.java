package calculatora;

import java.util.regex.Pattern;
/**
 * Establece las utilidades que va a tener la calculadora
 * @author Alumno mañana
 *
 */
public class Utilidades {
	
	/**
	 * Comprueba si es un número o un operador.
	 * Devuelve true si es un número (sea positivo o negativa, tenga o no tenga decimales)
	 * También devuelve true si es un operador.
	 * @param cadena
	 * @return
	 */
	public static boolean comprobarNumeroComaOperador(String cadena){
		return Pattern.matches("([-]|)[0-9]+[.][0-9]+|([-]|)[0-9]+[.]|([-]|)[0-9]+|[+]|[-]|[*]|[/]", cadena);		
	}
	
	/**
	 * Comprueba si el número introducido es decimal.
	 * @param Car
	 * @return
	 */
	public static boolean comprobarNumeroComa(char Car){
		String cadena = String.valueOf(Car);		
		return Pattern.matches("[.]|[0-9]", cadena);
	}
	
	/**
	 * Comprueba si el caracter introducido es un número.
	 * @param Car
	 * @return
	 */
	public static boolean comprobarNumero(char Car){
		String cadena = String.valueOf(Car);		
		return Pattern.matches("[0-9]", cadena);
	}
	
	/**
	 * Comprueba si el caracter introducido es un operador.
	 * @param Car
	 * @return
	 */
	public static boolean comprobarOperador(char Car){
		String cadena = String.valueOf(Car);
		return Pattern.matches("[+]|[-]|[*]|[/]", cadena);
	}
	
	/**
	 * Compara el caracter con el string.
	 * @param car
	 * @param text
	 * @return
	 */
	public static boolean comparar(char car, String text){
		String c = String.valueOf(car);
		return c.equals(text);
	}
	
	/**
	 * Comprueba si en el visor se emplea notación científica.
	 * @param text
	 * @return
	 */
	public static boolean compruebaNotacionCientifica(String text){
		return Pattern.matches(".+E.+", text);
	}
}
