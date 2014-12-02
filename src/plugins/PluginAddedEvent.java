package plugins;

import java.io.File;

public class PluginAddedEvent {

	private File file;

	public PluginAddedEvent(File file) {
		if ( file != null )
			if ( file.exists())
				this.file = file;
				
	}

	public String getFile(){
		return file.getName();
	}

}
