package editor.component;
import javax.swing.JMenuBar;

import editor.Editor;


/**
 * 
 */

/**
 * Class defining the 
 */
public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the MenuBar class
	 */
	public MenuBar(Editor editor) {
		super();
		this.add(new FileMenu(editor));
		this.add(new ToolsMenu());
		this.add(new HelpMenu());
	}

}
