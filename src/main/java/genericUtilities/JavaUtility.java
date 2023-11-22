package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to java
 * @author Debu Rupa
 * 
 */
public class JavaUtility {
	/**
	 * This method will return the current system date in specified format
	 * @return
	 */
	public String getSystemDateInFormatString()
	{
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String currentdate = formatter.format(d);
		return currentdate;
		
	}
	public int getRandomNumber() {
		Random r=new Random();
		int value = r.nextInt(100);
		return value;
	}
	

}
