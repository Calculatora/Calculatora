import calculatora.Automata;
import calculatora.GUICalculadora;
import calculatora.paneles.Resultados;

/**
 * Clase con la que vamos a ejecutar el programa.
 * @author Alumno mañana
 *
 */
public class Lanzar {
	
	/**
	 * Método main donde hacemos la llamada a todas las rutinas que componen nuestro programa.
	 * Dará funcionamiento al programa.
	 * @param args
	 */
	public static void main(String[] args) {
		GUICalculadora MiCalculadora = new GUICalculadora(); 
		new Automata(Resultados.dameResultado());
	} 
}
