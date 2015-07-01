package calculatora;

import java.util.regex.Pattern;

public class Utilidades {
	public static boolean comprobarNumeroComaOperador(String cadena){
		return Pattern.matches("([-]|)[0-9]+[.][0-9]+|([-]|)[0-9]+[.]|([-]|)[0-9]+|[+]|[-]|[*]|[/]", cadena);		
	}
	public static boolean comprobarNumeroComa(char Car){
		String cadena = String.valueOf(Car);		
		return Pattern.matches("[.]|[0-9]", cadena);
	}

	public static boolean comprobarNumero(char Car){
		String cadena = String.valueOf(Car);		
		return Pattern.matches("[0-9]", cadena);
	}
	
	public static boolean comprobarOperador(char Car){
		String cadena = String.valueOf(Car);
		return Pattern.matches("[+]|[-]|[*]|[/]", cadena);
	}
	
	public static boolean comparar(char car, String text){
		String c = String.valueOf(car);
		return c.equals(text);
	}
	
	public static boolean notacionCientifica(String text){
		return Pattern.matches(".+e.+", text);
	}
}
