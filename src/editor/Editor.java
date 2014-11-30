package editor;

/**
 * @author Nabil Maiz
 * @author Arnaud Cojez
 */

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

import editor.component.MenuBar;
import editor.component.TextArea;

/**
 * Class defining the Editor
 */
public class Editor {

	private JFrame frame;

	/**
	 * Constructor for the Editor class
	 */
	public Editor() {
		this.frame = new JFrame("eXditor 0.0.2");
		this.frame.addWindowListener(new FermeWindowEvent());
		this.frame.setLocation(100, 300);
		this.frame.setSize(200, 200);
		this.frame.add(new MenuBar(), BorderLayout.NORTH);
		this.frame.add(new TextArea());
	}
	/**
	 * Runs the Application until the user stops it
	 */
	public void run() {
		this.frame.pack();
		this.frame.setVisible(true);
	}

	/**
	 * Main method of the editor
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.run();

	}

	/**
	 * Internal Class used to manage the app closing when the user closes the
	 * window
	 */
	class FermeWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}


}
