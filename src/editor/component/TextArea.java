/**
 * 
 */
package editor.component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

/**
 * Class defining the Text Area
 */
public class TextArea extends JTextArea {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Methods
	/**
	 * Constructor for the TextArea class
	 */
	public TextArea() {
		super();
		this.setLineWrap(true);
	}

	public void openFile(File file) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			this.read(reader, null);
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier est introuvable");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Erreur lors de l'ouverture du fichier");
			e.printStackTrace();
		}
	}

}
