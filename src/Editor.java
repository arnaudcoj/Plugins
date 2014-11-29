import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Nabil Maiz
 * @author Arnaud Cojez
 */

/**
 * Class defining the Editor
 */
public class Editor {

	private JFrame frame;

	/**
	 * Constructor for the Editor class
	 */
	public Editor() {
		this.frame = new JFrame("eXditor 0.0.1");
		this.frame.addWindowListener(new FermeWindowEvent());
		this.frame.setLocation(100, 300);
		this.frame.setSize(200, 200);
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		file.add(new JMenuItem("Save"));
		file.add(new JMenuItem("Save As..."));
		file.add(new JMenuItem("Exit"));
		JMenu tools = new JMenu("Tools");
		JMenu help = new JMenu("Help");
		menu.add(file);
		menu.add(tools);
		menu.add(help);
		JTextArea textArea = new JTextArea(20, 50);
		this.frame.add(menu, BorderLayout.NORTH);
		this.frame.add(textArea, BorderLayout.SOUTH);
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
	/**
	 * Runs the editor until it is closed by the user
	 */
	public void run() {
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.run();

	}

	// ----------------------------------------------------------------------
	// CLASSE INTERNE, revue au point 2.5 du sujet de TP
	// pour gérér la fermeture de l'application lorsuq'on fere une fenêtre
	// ----------------------------------------------------------------------
	class FermeWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
}
