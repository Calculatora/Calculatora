package calculatora.eventos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import calculatora.Automata;
import calculatora.AutomataEspecial;
import calculatora.OpcionErronea;
import calculatora.paneles.Resultados;
import calculatora.superClass.BloqueBotones;

/**
 * Control del ratón
 * @author jfernandezpe
 * @since 2015/06/25
 */
public class ControlTeclado extends KeyAdapter {
	static BloqueBotones[] bloques;

	public ControlTeclado(BloqueBotones dig,
			BloqueBotones ope, BloqueBotones esp) {
		BloqueBotones[] tmpbloques = {dig,ope,esp};
		bloques = tmpbloques;
	}

	public ControlTeclado() {
		super();
	}

	/**
	 * Evento de cuando pulso una letra
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		

    }
	/**
	 * Evento de cuando presiono cualquier tecla
	 */
    @Override
    public void keyPressed(KeyEvent EventoQueLlega) {
    	if(EventoQueLlega.getKeyCode() == 32){
    		JButton boton = (JButton) EventoQueLlega.getSource();
    		Llamadas.llamoAutomata(boton);    		
    	} else if (EventoQueLlega.getKeyCode() == 27) {
			char Car = 'C';
			int i = 2; //Bloque de especial
			AutomataEspecial.limpiarOperaciones();
			bloques[i].ponerFoco(Car);
    	} else if (EventoQueLlega.getKeyCode() == 10) {
			char Car = '=';
			int i = 0; //Bloque de digitos
    		try { 
    			Automata.CaracterIntroducido(Car); 
    			bloques[i].ponerFoco(Car);
    		} catch(OpcionErronea er) {
    			Resultados.setText(er.mensajeError());
    			bloques[i].PonerFocoRojo(Car);
    		}
    	} else {
    		char Car = EventoQueLlega.getKeyChar();
    		try { 
    			Automata.CaracterIntroducido(Car);
    			for (int i = 0; i < bloques.length; i++){
    				bloques[i].ponerFoco(Car);
    			}
    		} catch(OpcionErronea er) {
    			Resultados.setText(er.mensajeError());
    			for (int i = 0; i < bloques.length; i++){
    				bloques[i].PonerFocoRojo(Car);
    			}
    		}
    	}
    }

    /**
     * Evento de cuando libero cualquier tecla
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

}
