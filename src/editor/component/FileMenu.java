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
	public FileMenu() {
		super("File");
		this.add(new JMenuItem("New"));
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
}
