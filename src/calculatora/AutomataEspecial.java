package calculatora;

import java.awt.TextField;

import calculatora.paneles.Resultados;

public class AutomataEspecial {

	private static double memoria;
	public static void limpiarUltimoNumero() {
		Resultados.setText("0");		
	}

	public static void limpiarTodo() {
		limpiarUltimoNumero();
		System.out.println("Implementar llamada a automata");
	}

	public static void cambiarSigno() {
		try {
			String sNumero = Resultados.dameResultado().getText();
			Double dNumero = Double.parseDouble(sNumero);
			dNumero = dNumero * (-1);
			sNumero = Double.toString(dNumero);
			Resultados.setText(sNumero);
		} catch (NumberFormatException e){
			limpiarUltimoNumero();
		}
	}

	public static void guardarMemoria() {
		try {
			memoria = Double.parseDouble(Resultados.dameResultado().getText());
		} catch (NumberFormatException e){
			borrarMemoria();
		}
		
	}

	public static void borrarMemoria() {
		memoria = 0;
		
	}

	public static void recuperarMemoria() {
		String sNumero = Double.toString(memoria);
		Resultados.setText(sNumero);
		
	}

}
