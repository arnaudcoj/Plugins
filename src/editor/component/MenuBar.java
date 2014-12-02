package editor.component;
import javax.swing.JMenuBar;

import editor.Editor;

/**
 * Class defining the Menu Bar
 */
public class MenuBar extends JMenuBar {

	//Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Methods
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
