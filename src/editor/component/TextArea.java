/**
 * 
 */
package editor.component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import editor.Editor;

/**
 * Class defining the Text Area
 */
public class TextArea extends JTextArea {

	// Fields
	private static final long serialVersionUID = 1L;
	private Editor editor;

	// Methods
	/**
	 * Constructor for the TextArea class
	 */
	public TextArea(Editor editor) {
		super();
		this.editor = editor;
		this.setLineWrap(true);
		this.getDocument().addDocumentListener(new ChangedDocumentListener(this.editor));
	}

	public void readFile(File file) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			this.read(reader, null);
			this.getDocument().addDocumentListener(new ChangedDocumentListener(this.editor));
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier est introuvable");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Erreur lors de l'ouverture du fichier");
			e.printStackTrace();
		}
	}
	
	public void writeFile(File file) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			this.write(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class ChangedDocumentListener implements DocumentListener {

		
		private Editor editor;

		public ChangedDocumentListener(Editor editor) {
			this.editor = editor;
		}

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			this.editor.setNotSaved();
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			this.editor.setNotSaved();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			this.editor.setNotSaved();
		}
		
	}
}
