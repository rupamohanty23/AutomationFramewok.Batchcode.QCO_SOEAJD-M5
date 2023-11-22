package contactTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepositary.ContactInfoPage;
import objectRepositary.ContactsPage;
import objectRepositary.CreateNewContactPage;
import objectRepositary.HomePage;
import objectRepositary.LoginPage;

public class CreateContactTest extends BaseClass {
	@Test(groups="SmokeSuite")
	public void  CreateContactTest() throws IOException {
		
		//Create object of all Utilities
		//ExcelFileUtility eUtil=new ExcelFileUtility();
		//PropertyFileUtility pUtil=new PropertyFileUtility();
		//WebDriverUtility wUtil=new WebDriverUtility();
		//JavaUtility jUtil=new JavaUtility();
		//WebDriver driver=null;
		
		//Step 1:Read all the required Data
		/* Common Data*/
		// Step 1: Read all the required Data
		//String BROWSER  = pUtil.readDataFromPropertyFile("browser");
		//String URL = pUtil.readDataFromPropertyFile("url");
		//String USERNAME = pUtil.readDataFromPropertyFile("username");
		//String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	/*Test Data*/
	String LASTNAME= eUtil.readDataFromExcel("Contacts", 1, 2);
	//Step 2:Launch the browser
	//if(BROWSER.equalsIgnoreCase("Chrome")) //true f
	//{
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		
	//}
	//else if(BROWSER.equalsIgnoreCase("Firefox")) {
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();
	//}
	
	//else if(BROWSER.equalsIgnoreCase("Edge")) {
		//WebDriverManager.edgedriver().setup();
		//driver=new EdgeDriver();
	//}
	//else 
	//{
	//	System.out.println("Invalid Browser name");
		
	//}
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.get(URL);
	
	//Step 3:Login To Application
	//LoginPage lp=new LoginPage(driver);
	//lp.loginToApp(USERNAME,PASSWORD);
	
	//Step 4:Navigate to contacts link
	HomePage hp=new HomePage(driver);
	hp.clickonContactsLnk();
	
	//Step 5:Click on create contact look up Image
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnCreateContactLookUpImg();
	
	Assert.fail();
	
	//Step 6:Create new Contact
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
	
	//step 7:Validate
	 ContactInfoPage cip=new ContactInfoPage(driver) ; 
	 String contactheader = cip.getContactHeader();
	 Assert.assertTrue(contactheader.contains(LASTNAME));
	 System.out.println(contactheader);
	} 
	
	
	 @Test
	 public void demo()
	 {
		 System.out.println("demo");
	 }
	
	}

