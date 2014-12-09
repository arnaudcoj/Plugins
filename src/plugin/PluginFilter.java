/**
 * 
 */
package plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

/**
 * @author Maiz Nabil
 * @author Cojez Arnaud
 */
public class PluginFilter implements FilenameFilter {

	/* 
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File dir, String name) {
		if(!fileExtensionIsClass(name)){
		return false;
		}
		Class<?> theClass = getClass(dir,name);
		if(theClass == null){
			return false;
		}
		
		return inheritFromPlugin(theClass) && classInPluginPackage(theClass) && classHasParameterlessClassConstructor(theClass);
	}
	
	protected boolean fileExtensionIsClass(String filename){
		return filename.endsWith(".class");
	}
	
	protected Class<?> getClass(File dir,String filename){
		String className = filename.replace("\\.class$", "");
		try{
			return Class.forName("plugins" + className);
		}catch(ClassNotFoundException e){
			return null;
		}
	}
	
	protected boolean inheritFromPlugin(Class<?> theClass){
		return Plugin.class.isAssignableFrom(theClass);
	}

	protected boolean classInPluginPackage (Class<?> theClass){
		return theClass.getPackage().getName().equals("plugins");
				}
	
	public boolean classHasParameterlessClassConstructor(Class<?> theClass){
		for(Constructor<?> constructor: theClass.getConstructors()){
			if(constructor.getParameterTypes().length == 0){
				return true;
			}
		}
		return false;
	}

}
