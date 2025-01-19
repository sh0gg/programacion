package ud4.arraysejercicios;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PruebaGUI {
    public static void main(String[] args) {
	        JFrame frame = new JFrame("Ejemplo Swing");
	        JButton button = new JButton("Haz click aquí");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(button);
	        frame.setSize(300, 200);
	        frame.setVisible(true);
	    }

}
