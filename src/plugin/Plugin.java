package plugin;

/**
 * represents a plugin that can be dynamically added to the extendable editor. A
 * plugin can perform a transformation on a String. A menu item corresponds to a
 * a plugin in the editor. The label of this item is given by the
 * <code>getLabel</code> method.
 * 
 * @author Arnaud Cojez
 * @author Maiz Nabil
 */
public interface Plugin {

	/** the package name of plugins */
	public static final Object PACKAGE_NAME = "plugins";

	/**
	 * performs a transformation on a string
	 * 
	 * @param s
	 *            the string to be transformed
	 * @return the transformed string
	 */
	public String transform(String s);

	/**
	 * returns a label associated to this plugin.
	 * 
	 * @return a label associated to this plugin.
	 */
	public String getLabel();

	/**
	 * a help message describing the plugin transformation operation
	 * 
	 * @return a help message describing the plugin transformation operation
	 */
	public String helpMessage();

}
