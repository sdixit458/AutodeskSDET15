package Generics;

import java.io.FileReader;
import java.util.HashMap;
import org.json.simple.parser.JSONParser;
/**
 * This class read the data from JSON file
 * @author Saurabh
 *
 */
public class JsonFileUtility {
	/**
	 * This method use to read the data from JSON file
	 * @author Saurabh 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromJson(String key) throws Throwable {
		//Read the data from JSON
		FileReader reader=new FileReader(IPathConstants.JSONPATH);
		
		//parse the json object into java data stream
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(reader);
		
		//type cast the object into hashmap and read the data from key value format
		HashMap jobj=(HashMap)obj;
		String value = jobj.get(key).toString();
		return value;
	}

}
