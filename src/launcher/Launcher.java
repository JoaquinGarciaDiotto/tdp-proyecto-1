package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		Student JoaquinGarciaDiotto = new Student(124996,"Garcia Diotto","Joaquin","joaquinmichu@hotmail.com","https://github.com/Skorrom","/images/foto.png");
		SimplePresentationScreen GUI = new SimplePresentationScreen(JoaquinGarciaDiotto);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	GUI.setVisible(true);
            }
        });
    }
}