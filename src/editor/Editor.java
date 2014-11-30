package editor;

/**
 * @author Nabil Maiz
 * @author Arnaud Cojez
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

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
		this.initWindow();
	}

	/**
	 * Initializes the menu bar with the File, Tools and Help Menu
	 */
	private void initWindow() {
		this.frame.addWindowListener(new FermeWindowEvent());
		this.frame.setLocation(100, 300);
		this.frame.setSize(200, 200);
		JMenuBar menu = new JMenuBar();
		menu.add(this.createFileMenu());
		menu.add(this.createToolsMenu());
		menu.add(this.createHelpMenu());
		JTextArea textArea = new JTextArea(20, 50);
		this.frame.add(menu, BorderLayout.NORTH);
		this.frame.add(textArea, BorderLayout.SOUTH);
	}

	/**
	 * Returns a JMenu with all the File-related options
	 * 
	 * @return a JMenu with all the File-related options
	 */
	private JMenu createFileMenu() {
		JMenu file = new JMenu("File");
		file.add(new JMenuItem("New"));
		file.add(new JMenuItem("Save"));
		file.add(new JMenuItem("Save As..."));
		file.add(new JMenuItem("Open..."));
		file.add(new JSeparator());
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitEvent());
		file.add(exit);
		return file;
	}

	/**
	 * Returns a JMenu with all the Tools (plugins)
	 * 
	 * @return a JMenu with all the Tools (plugins)
	 */
	private JMenu createToolsMenu() {
		JMenu tools = new JMenu("Tools");
		return tools;
	}

	/**
	 * Returns a JMenu with the descriptions of the Tools (plugins)
	 * 
	 * @return a JMenu with the descriptions of the Tools (plugins)
	 */
	private JMenu createHelpMenu() {
		JMenu help = new JMenu("Help");
		return help;
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
