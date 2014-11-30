package editor.component;
import javax.swing.JMenuBar;


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
	public MenuBar() {
		super();
		this.add(new FileMenu());
		this.add(new ToolsMenu());
		this.add(new HelpMenu());
	}

}
