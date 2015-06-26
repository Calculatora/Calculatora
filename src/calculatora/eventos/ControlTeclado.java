package calculatora.eventos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

/**
 * Control del ratón
 * @author jfernandezpe
 * @since 2015/06/25
 */
public class ControlTeclado extends KeyAdapter {
	
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
    	if(EventoQueLlega.getKeyCode() == 10){
    		JButton boton = (JButton) EventoQueLlega.getSource();
    		Llamadas.llamoAutomata(boton);    		
    	}

    }

    /**
     * Evento de cuando libero cualquier tecla
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

}
