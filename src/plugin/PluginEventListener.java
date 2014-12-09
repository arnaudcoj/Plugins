/**
 * 
 */
package plugin;

import java.util.EventListener;



/**
 * @author Maiz Nabil
 * @author Cojez Arnaud
 */
public interface PluginEventListener extends EventListener {

	public void pluginAdded(PluginAddedEvent listener);
	

}
