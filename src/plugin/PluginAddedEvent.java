package plugin;

import java.io.File;

import plugin.Plugin;

public class PluginAddedEvent implements Plugin {
	private File file;
	protected Plugin instance;

	public PluginAddedEvent(File file) {
		ClassLoader loader = new PluginLoader();
		Class<?> plugin;
		if (file != null)
			if (file.exists())
				this.file = file;
		try {
			String pluginName = "plugins."
					+ file.getName().replaceFirst("\\.class$", "");
			
			plugin = loader.loadClass(pluginName);
			
			this.instance = (Plugin) plugin.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public String getFile() {
		return file.getName();
	}

	public String transform(String s) {
		return this.instance.transform(s);
	}

	public String getLabel() {
		return this.instance.getLabel();
	}

	public String helpMessage() {
		return this.instance.helpMessage();
	}
	
	public class PluginLoader extends ClassLoader {
		
	}
	
}
