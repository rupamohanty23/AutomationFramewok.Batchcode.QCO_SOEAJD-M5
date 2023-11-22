package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepositary.ContactInfoPage;
import objectRepositary.ContactsPage;
import objectRepositary.CreateNewContactPage;
import objectRepositary.CreateNewOrganizationPage;
import objectRepositary.HomePage;
import objectRepositary.LoginPage;
import objectRepositary.OrganizationInfoPage;
import objectRepositary.OrganizationsPage;

public class CreateContactWithOrgTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		// Create Object of all Utilities
				ExcelFileUtility eUtil = new ExcelFileUtility();
				PropertyFileUtility pUtil = new PropertyFileUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				JavaUtility jUtil = new JavaUtility();
				WebDriver driver = null;

				// Step 1: Read all the required Data
				/* Common Data */
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String URL = pUtil.readDataFromPropertyFile("url");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");

				/* Test Data */
				String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
				String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
				

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
				
				//Login
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				//Navigate to Org link
				HomePage hp = new HomePage(driver);
				hp.clickonOrgLnk();
				
				//Click on Org look Up Image
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrgLookUpImg();
				
				//Create new Organization
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrganization(ORGNAME);
				
				//Validate for Organization
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String orgHeader = oip.getOrganizationHeader();
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println(orgHeader);
					System.out.println("Organization created");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Navigate to contacts
				hp.clickonContactsLnk();
				
				//Click on Create Contact look up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
				//Create  contact with Organization
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(driver, ORGNAME, LASTNAME);
				
				//Validate
				ContactInfoPage cip = new ContactInfoPage(driver);
				String contactHeader = cip.getContactHeader();
				if(contactHeader.contains(LASTNAME))
				{
					System.out.println(contactHeader);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Logout
				hp.logoutofApp(driver);
				
				//Close browser
				driver.quit();
				
	}
	

}
