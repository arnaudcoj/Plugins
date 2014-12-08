package editor;

/**
 * @author Nabil Maiz
 * @author Arnaud Cojez
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;

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
	private File file;
	private boolean saved;
	private static final String VERSION = "eXditor 0.1.3";

	// Methods
	/**
	 * Constructor for the Editor class
	 */
	public Editor() {
		this.frame = new JFrame();
		this.frame.addWindowListener(new FermeWindowEvent());
		this.frame.setLocation(100, 300);
		this.frame.add(new MenuBar(this), BorderLayout.NORTH);
		this.textarea = new TextArea(this);
		JScrollPane sp = new JScrollPane(this.textarea);
		this.frame.add(sp);
		this.frame.setPreferredSize(new Dimension(500, 300));
		this.saved = false;
		this.updateTitle();
	}

	/**
	 * Runs the Application until the user stops it
	 */
	public void run() {
		this.frame.pack();
		this.frame.setVisible(true);

	}

	public void updateTitle() {
		StringBuilder sb = new StringBuilder();
		if (!this.saved)
			sb.append('*');
		if (this.file == null)
			sb.append("untitled");
		else
			sb.append(this.file.getName());
		sb.append(" | ");
		sb.append(Editor.VERSION);
		this.frame.setTitle(sb.toString());
	}

	/**
	 * Resets the editor to work on a new Document
	 */
	public void reset() {
		this.textarea.setText(null);
		this.file = null;
		this.saved = false;
		this.updateTitle();
	}

	/**
	 * Saves the Document to the output if it is known. If the output file is
	 * unknown, makes a call to saveAs
	 */
	public void save() {
		if (this.file == null)
			this.chooseFile();
		if (this.file != null) {
			if (!this.file.exists())
				try {
					this.file.createNewFile();
				} catch (IOException e) {
					System.out.println("erreur lors de la création du fichier"
							+ this.file.getAbsolutePath());
					e.printStackTrace();
				}
			this.textarea.writeFile(this.file);
			this.saved = true;
		}
		this.updateTitle();
	}

	/**
	 * Asks the user to choose an output file and saves to it
	 */
	public void saveAs() {
		this.chooseFile();
		if (this.file != null) {
			if (!this.file.exists())
				try {
					this.file.createNewFile();
				} catch (IOException e) {
					System.out.println("erreur lors de la création du fichier"
							+ this.file.getAbsolutePath());
					e.printStackTrace();
				}
			this.textarea.writeFile(this.file);
			this.saved = true;
		}
		this.updateTitle();
	}

	/**
	 * Opens an existing file and fills textArea with the content of this file
	 */
	public void open() {
		this.chooseFile();
		if (this.file != null) {
			if (this.file.exists()) {
				this.textarea.readFile(this.file);
				this.saved = true;
			}
		}
		this.updateTitle();
	}

	/**
	 * Chooses an existing file or creates one thanks to a FileChooser
	 */
	public void chooseFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(fc);

		if (returnVal == JFileChooser.APPROVE_OPTION)
			this.file = fc.getSelectedFile();
	}

	/**
	 * Sets [saved] to false
	 */
	public void setNotSaved() {
		this.saved = false;
		this.updateTitle();
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

	/**
	 * Main method of the editor
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.run();

	}
}