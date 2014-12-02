package editor;

/**
 * @author Nabil Maiz
 * @author Arnaud Cojez
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import editor.component.MenuBar;
import editor.component.TextArea;

/**
 * Class defining the Editor
 */
public class Editor {

	// Fields
	private JFrame frame;
	private TextArea textarea;

	// Methods
	/**
	 * Constructor for the Editor class
	 */
	public Editor() {
		this.frame = new JFrame("eXditor 0.0.4");
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
	 * Resets the editor to work on a new Document
	 */
	public void reset() {
		this.textarea.setText(null);
	}

	/**
	 * Saves the Document to the output if it is known. If the output file is
	 * unknown, makes a call to saveAs
	 */
	public void save() {
	}

	/**
	 * Asks the user to choose an output file and saves it
	 */
	public void saveAs() {
		System.out.println("to be implemented : saveAs().  Text to save :");
		System.out.println(this.textarea.getText());
	}

	/**
	 * Opens an existing file and fills textArea with the content of this file
	 */
	public void open() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(fc);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			this.textarea.openFile(file);
		}
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