/**
 * 
 */
package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Maiz Nabil
 * @author Cojez Arnaud
 */
public class PluginFinder implements ActionListener {

	// ATTRIBUTES
	private static final int refreshInterval_ms = 1000;
	protected final File directory;
	protected final List<PluginEventListener> listener = new ArrayList<PluginEventListener>();
	protected final ConfigurableTimer timer;
	protected Set<File> knownFiles = new HashSet<File>();
	protected PluginFilter filter;
	
	//CONSTRUCTOR
	
	public PluginFinder(File directory){
		super();
		this.directory = directory;
		this.timer = new ConfigurableTimer(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Set<File> currentFiles = this.listFiles();
		Set<File> newFiles = new HashSet<File>(currentFiles);
		newFiles.removeAll(knownFiles);
		
		for(File file: newFiles){
			notifyListener(file);
		}
		knownFiles = currentFiles;
	}
	
	public Set<File> listFiles(){
		return new HashSet<File>(Arrays.asList(directory.listFiles(filter))); 
	}
	
	protected void notifyListener(File file){
		ArrayList <PluginEventListener> listenerCopy;
		listenerCopy = new ArrayList<PluginEventListener>(listener);
		for(PluginEventListener listener: listenerCopy){
			listener.pluginAdded(new PluginAddedEvent(file));
		}
	}
	
	public void start(){
		timer.start(refreshInterval_ms);
	}
	
	public synchronized void addListener(PluginEventListener listener){
		this.listener.add(listener);
	}
}
