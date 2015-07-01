package calculatora;

import calculatora.paneles.Resultados;

/**
 * Realiza las funciones de los botones especiales (memoria, borrar y cambiar el signo).
 * 
 * @author jfernandezpe
 * @since 2015/06/25
 *
 */
public class AutomataEspecial {

	private static double memoria;
	
	/**
	 * Limpia el n�mero el �ltimo n�mero completo con el que se est� operando
	 * (no borra todo el n�mero, no solo el �ltimo digito)
	 */
	public static void limpiarUltimoNumero() {
		Resultados.setText("0");		
		Automata.setEstado( (byte) -1);
	}

	/**
	 * Limpia los registros de las operaciones
	 */
	public static void limpiarOperaciones() {
		limpiarUltimoNumero();
		Automata.setEstado((byte) 0);
	}

//	/**
//	 * Cambia el signo de n�mero en display
//	 */
//	public static void cambiarSigno() {
//		try {
//			String sNumero = Resultados.dameResultado();
//			Double dNumero = Double.parseDouble(sNumero);
//			dNumero = dNumero * (-1);
//			sNumero = Double.toString(dNumero);
//			Resultados.setText(sNumero);
//		} catch (NumberFormatException e){
//			limpiarUltimoNumero();
//		}
//	}

	/**
	 * Guarda el n�mero en display en memoria
	 */
	public static void guardarMemoria() {
		try {
			memoria = Double.parseDouble(Resultados.dameResultado());
		} catch (NumberFormatException e){
			borrarMemoria();
		}
		
	}

	/**
	 * Borra el n�mero en memoria
	 */
	public static void borrarMemoria() {
		memoria = 0;
		
	}

	/**
	 * Recupera en la pantalla el n�mero en memoria
	 */
	public static void recuperarMemoria() {
		String sNumero = Double.toString(memoria);
		Resultados.setText(sNumero);
		
	}

}
