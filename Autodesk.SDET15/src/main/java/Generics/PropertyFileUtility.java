package Generics;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This class will read the data from properties file
 * @author Saurabh
 *
 */
public class PropertyFileUtility {
	/**
	 * This method will read the data from properties file
	 * @author Saurabh
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.PROPERTYFILEPATH);
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
