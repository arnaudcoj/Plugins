package plugin;

/*
 * @author Maiz Nabil
 * @author Cojez Arnaud
 */
public class PluginAddLogger implements PluginEventListener {

	@Override
	public void pluginAdded(PluginAddedEvent e) {
		System.out.println(e.getFile());
	}



}
