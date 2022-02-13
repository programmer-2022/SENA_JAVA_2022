package utils;

import javax.swing.JOptionPane;

public class Messages {

    public static void msgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void msgSuccess(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
    }    
}
