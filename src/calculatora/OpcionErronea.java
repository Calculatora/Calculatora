package calculatora;

/**
 * Clase en la cual se definen las excepciones del proyecto Calculator.
 * @author Fernando Pacheco Sáncehez.
 *
 */
public class OpcionErronea extends Exception {
	
	/**
	 * Serial 1L que identifica a la clase de excepciones "OpcionErronea".
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Método que retorna una cadena con el mensaje de "Error".
	 * @return Una cadena con dicho mensaje.
	 */
	public String mensajeError(){
		String mensaje = "Error";
		return mensaje;		
	}
	
	/**
	 * Método que retorna una cadena con el mensaje de "Número incorrecto".
	 * @return Una cadena con dicho mensaje.
	 */
	public String numError(){
		String mensaje = "Número incorrecto";
		return mensaje;
	}
	
	/**
	 * Método que retorna una cadena con el mensaje de "Operador incorrecto".
	 * @return Una cadena con dicho mensaje.
	 */
	public String operdrError(){
		String mensaje = "Operador incorrecto";
		return mensaje;
	}
	
	/**
	 * Método que retorna una cadena con el mensaje de "No se puede dividor por 0".
	 * @return Una cadena con dicho mensaje.
	 */
	public String divCero(){
		String mensaje = "No se puede dividor por 0";
		return mensaje;
	}
}
