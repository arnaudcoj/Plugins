/**
 * 
 */
package editor.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import editor.Editor;


/**
 * Class defining the 
 */
public class FileMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the FileMenu class
	 */
	public FileMenu(Editor editor) {
		super("File");
		JMenuItem newFile = new JMenuItem("New");
		newFile.addActionListener(new NewFileEvent(editor));
		this.add(newFile);
		this.add(new JMenuItem("Save"));
		this.add(new JMenuItem("Save As..."));
		this.add(new JMenuItem("Open..."));
		this.add(new JSeparator());
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitEvent());
		this.add(exit);
	}

	/**
	 * Internal Class used to manage the app closing when the user chooses the
	 * Exit item in the Menu
	 */
	class ExitEvent implements ActionListener, ItemListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent
		 * )
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {
			// Nothing to do there
		}
	}
	
	/**
	 * Internal Class used to manage the app reset when the user chooses the
	 * New item in the Menu
	 */
	class NewFileEvent implements ActionListener, ItemListener {

		private Editor editor;
		
		public NewFileEvent(Editor editor) {
			this.editor = editor;
		}

		
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		public void actionPerformed(ActionEvent e) {
			this.editor.reset();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent
		 * )
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {
			// Nothing to do there
		}
	}
}
