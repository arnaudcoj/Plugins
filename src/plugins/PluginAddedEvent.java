package plugins;

import java.io.File;

public class PluginAddedEvent implements Plugin {
	private File file;
	protected Plugin instance;

	public PluginAddedEvent(File file) {
		if (file != null)
			if (file.exists())
				this.file = file;
		Class<?> classTest;
		try {
			classTest = Class.forName("plugins."
					+ file.getName().replaceFirst("\\.class$", ""));
			//classTest = Class.forName("plugins.ToLowerCase");
			this.instance = (Plugin) classTest.newInstance();
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
}
