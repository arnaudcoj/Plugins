/**
 * 
 */
package editor.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import plugins.Plugin;
import plugins.PluginAddedEvent;
import plugins.PluginEventListener;
import editor.Editor;

/**
 * Class defining the Tools Menu
 */
public class ToolsMenu extends JMenu {
	// Fields
	private static final long serialVersionUID = 1L;

	// Methods
	/**
	 * Constructor for the ToolsMenu class
	 */
	public ToolsMenu() {
		super("Tools");
	}

	// ############################################################################################
	public class ToolsMenuListener implements PluginEventListener {
		private Editor editor;
		private ToolsMenu toolsMenu;

		public ToolsMenuListener(Editor editor, ToolsMenu toolsMenu) {
			this.editor = editor;
			this.toolsMenu = toolsMenu;
		}

		@Override
		public void pluginAdded(PluginAddedEvent plugin) {
			JMenuItem menuItem = new JMenuItem(plugin.getLabel());
			menuItem.addActionListener(new ToolListener(plugin, this.editor));
			this.toolsMenu.add(menuItem);
		}
	}

	// ############################################################################################
	public class ToolListener implements ActionListener {

		private Editor editor;
		private Plugin plugin;

		public ToolListener(Plugin plugin, Editor editor) {
			this.editor = editor;
			this.plugin = plugin;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String selection = this.editor.getSelectedText();
			if (selection != null)
				this.editor.replaceSelection(this.plugin.transform(selection));
		}
	}
}
