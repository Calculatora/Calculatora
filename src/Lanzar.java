import calculatora.Automata;
import calculatora.GUICalculadora;
import calculatora.Resultados;


public class Lanzar {
	public static void main(String[] args) {
		GUICalculadora MiCalculadora = new GUICalculadora(); 
		new Automata(Resultados.dameResultado());
	} 
}