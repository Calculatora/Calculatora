package calculatora.eventos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class ControlVentana implements WindowListener{
	
	public void windowClosing(WindowEvent EventoQueLlega){
		System.exit(0);
	}

	public void windowActivated(WindowEvent e){
        System.out.println("windowActivated");
    }

    public void windowClosed(WindowEvent e){
        System.out.println("windowClosed");
    }

    public void windowDeactivated(WindowEvent e){
        System.out.println("windowDeactivated");
    }

    public void windowDeiconified(WindowEvent e){
        System.out.println("windowDeiconified");
    }

    public void windowIconified(WindowEvent e){
        System.out.println("windowIconified");
    }

    public void windowOpened(WindowEvent e){
        System.out.println("windowOpened");
    }
}