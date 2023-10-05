package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sceneario1WithDDT {
	public static void main(String[] args) throws IOException, InterruptedException {
		//Step1:Read all the required data
		/*Common Data*/
		FileInputStream fisp=new FileInputStream("src/test/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*Test Data*/
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		 Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(0).getCell(2).getStringCellValue();
		
		WebDriver driver = null;  //WebDriver driver=null;
		
		//step 2:Launch the browser -PolyMorphism-Run Time-Driver
		if(BROWSER.equalsIgnoreCase("Chrome")) //true f
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else 
		{
			System.out.println("Invalid Browser name");
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		//Step 3:Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//Step 4:Navigate to Contacts Link
		driver.findElement(By.linkText("Contacts")).click();
		//Step 5:Click on Create Contact look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//Step 6:Create Contact with Mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		//Step 7:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Step 8:Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(LASTNAME)) {
			System.out.println(contactHeader);
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		//Step 9:Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout is successful");
		
		
		
	}

	
}

