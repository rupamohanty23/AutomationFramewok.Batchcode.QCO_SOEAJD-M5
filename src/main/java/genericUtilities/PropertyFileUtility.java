package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//singleline comment
	/*multi line comment */

public class PropertyFileUtility {
	/**
	 * This method will read data from propertyFile for the key provided by caller 
	 * and return the value to caller
	 * @param key
	 * @return Value
	 * @throws IOException
	 */
	public static String readDataFromPropertyFile(String key) throws IOException {
		
		//step1:Open the document in java Readable Format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step2:Create an Object properties class  from java.util
		Properties p=new Properties();
		//Step3:load the input stream into properties
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}