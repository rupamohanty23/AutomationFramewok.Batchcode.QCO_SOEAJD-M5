package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;




public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException  {
		//step1:Open the document in java Readable Format
		FileInputStream fis=new FileInputStream("src/test/resources/CommonData.properties");
		
		//Step2:Create an Object properties class  from java.util
		Properties p=new Properties();
		//Step3:load the input stream into properties
		p.load(fis);
		//step4:provide the keys to read the values
		String Value = p.getProperty("browser");
		System.out.println(Value);
		
	}

}
