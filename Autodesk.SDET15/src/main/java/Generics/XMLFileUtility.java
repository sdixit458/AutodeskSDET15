package Generics;


import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
/**
 * This class is use to read data from xml file
 * @author Saurabh
 *
 */
public class XMLFileUtility {
	/**
	 * This method is use to read data from xml file
	 * @author Saurabh
	 * @param node
	 * @return
	 * @throws DocumentException
	 */
	
	public String readDataFromXmlFile(String node) throws DocumentException {
		//Read the xml file
		File inputfile=new File(IPathConstants.XMLPATH);
		
		//Read the data from input file
		SAXReader reader=new SAXReader();
		Document doc = reader.read(inputfile);
		
		//Navigate to a particular node to get the value
		String value = doc.selectSingleNode("//commonData/"+node).getText();
		return value;
	}

}
