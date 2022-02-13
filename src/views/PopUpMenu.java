package views;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class PopUpMenu extends AbstractAction {

    private String textoOpcion;
    
    public PopUpMenu(String textoOpcion) {
        this.textoOpcion = textoOpcion;
        this.putValue(Action.NAME, textoOpcion);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Pulsado " + textoOpcion);
    }
    
}
