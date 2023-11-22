package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sceneario1WithDDTAndGU {
	
	public static void main(String[] args) throws IOException, InterruptedException {
	
	//Create object of all Utilities
	ExcelFileUtility eUtil=new ExcelFileUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	JavaUtility jUtil=new JavaUtility();
	WebDriver driver=null;
	
	// Step 1: Read all the required Data
	String BROWSER  = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	
	/*Test Data*/
	String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);

	// Step 2: Launch the browser - PolyMorphism - Run Time - Driver
	if (BROWSER.equalsIgnoreCase("Chrome"))// true f
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	} else if (BROWSER.equalsIgnoreCase("Firefox")) // t f
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	} else if (BROWSER.equalsIgnoreCase("Edge"))// f
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	} else {
		System.out.println("invalid Browser name");
	}

	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver);
	driver.get(URL);

	// Step 3: Login to Application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();

	// Step 4: navigate to Contacts link
	driver.findElement(By.linkText("Contacts")).click();

	// Step 5: click on create contact look Up Image
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

	// Step 7: create contact with mandatory fields
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

	// Step 7: save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	// Step 8: Validate
	String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if (contactHeader.contains(LASTNAME)) {
		System.out.println(contactHeader);
		System.out.println("PASS");
	} else {
		System.out.println("FAIL");
	}

	// Step 9: Logout
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

	wUtil.mouseHoverAction(driver, ele);
	
	Thread.sleep(1000);
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Logout is successfull");

	}

}
