package editor;

/**
 * @author Nabil Maiz
 * @author Arnaud Cojez
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import editor.component.MenuBar;
import editor.component.TextArea;

/**
 * Class defining the Editor
 */
public class Editor {

	private JFrame frame;
	private TextArea textarea;

	/**
	 * Constructor for the Editor class
	 */
	public Editor() {
		this.frame = new JFrame("eXditor 0.0.3");
		this.frame.addWindowListener(new FermeWindowEvent());
		this.frame.setLocation(100, 300);
		this.frame.add(new MenuBar(this), BorderLayout.NORTH);
		this.textarea = new TextArea();
		JScrollPane sp = new JScrollPane(this.textarea);
		this.frame.add(sp);
		this.frame.setPreferredSize(new Dimension(400, 200));
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
	 * 
	 */
	public void reset() {
		this.textarea.setText(null);
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
