package calculatora.eventos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import calculatora.Automata;
import calculatora.OpcionErronea;
import calculatora.Utilidades;
import calculatora.paneles.Resultados;
import calculatora.superClass.BloqueBotones;

/**
 * Control del ratón
 * @author jfernandezpe
 * @since 2015/06/25
 */
public class ControlTeclado extends KeyAdapter {
	static BloqueBotones digitos;
	static BloqueBotones operadores;
	static BloqueBotones especiales;

	public ControlTeclado(BloqueBotones instanciaDig,
			BloqueBotones instanciaOpe, BloqueBotones instanciaEspeciales) {
		digitos = instanciaDig;
		operadores = instanciaOpe;
		especiales = instanciaEspeciales;
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
    	digitos.quitarRojo();
    	operadores.quitarRojo();
    	especiales.quitarRojo();
    	if(EventoQueLlega.getKeyCode() == 32){
    		JButton boton = (JButton) EventoQueLlega.getSource();
    		Llamadas.llamoAutomata(boton);    		
    	} else if (EventoQueLlega.getKeyCode() == 10) {
			char Car = '=';
    		try { 
    			Automata.CaracterIntroducido(Car); 
    		} catch(OpcionErronea er) {
    			Resultados.setText(er.mensajeError());
    		}
    	} else {
    		char Car = EventoQueLlega.getKeyChar();
    		if (Utilidades.comprobarNumeroComa(Car)) {
	    		try { 
	    			Automata.CaracterIntroducido(Car); 
	    		} catch(OpcionErronea er) {
	    			Resultados.setText(er.mensajeError());
	    			digitos.PonerRojo(Car);
	    		}
    		} else if (Utilidades.comprobarOperador(Car)){
	    		try { 
	    			Automata.CaracterIntroducido(Car); 
	    		} catch(OpcionErronea er) {
	    			Resultados.setText(er.mensajeError());
	    			operadores.PonerRojo(Car);
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
