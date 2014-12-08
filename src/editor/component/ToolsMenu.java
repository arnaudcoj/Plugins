/**
 * 
 */
package editor.component;

import java.io.File;

import javax.swing.JMenu;

import plugins.PluginFinder;

/**
 * Class defining the Tools Menu
 */
public class ToolsMenu extends JMenu {

	private final File dropins = new File("./dropins");
	private final PluginFinder finder = new PluginFinder(dropins);
	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Methods
	/**
	 * Constructor for the ToolsMenu class
	 */
	public ToolsMenu() {
		super("Tools");
		if (!this.dropins.exists())
			this.dropins.mkdir();
	}
	
	public void update() {
	}
}
