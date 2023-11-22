package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepositary.HomePage;
import objectRepositary.LoginPage;
 
public class BaseClass {
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriver driver=null;
	
	
	@BeforeSuite
	public void bsConfig()
	{
	 System.out.println("===  DB Connection Successful===");	
	}
	//@Parameters("browser")
	@BeforeClass
	public void bcConfig() throws IOException 
	{
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"=== Browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"=== Browser launched");
		
	}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+"=== Browser launched");
		}
		else {
			System.out.println("---Invalid browser Name---");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	@BeforeMethod
	public void bmConfig() throws IOException 
	{
         String USERNAME = pUtil.readDataFromPropertyFile("username");
        String PASSWORD= pUtil.readDataFromPropertyFile("password");
        
        LoginPage Ip=new LoginPage(driver);
        Ip.loginToApp(USERNAME, PASSWORD);
		System.out.println("=== Login Successful===");
	}
	@AfterMethod
	public void amConfig() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.logoutofApp(driver);
		System.out.println("=== Logout Successful");
	}
	@AfterClass
	public void acConfig() 
	{
		driver.quit();
		System.out.println("==== Browser Closed Successfully===");
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println("=== DB Closed Successfully===");
	}
	

}
