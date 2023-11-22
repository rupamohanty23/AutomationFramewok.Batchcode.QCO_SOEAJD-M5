package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sceneario3 {
	public static void main(String[] args) {
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		
     //		Login to application with valid credentials
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	//	Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
	//Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//Create Organization with Mandatory fields
		driver.findElement(By.name("accountname"));
	//	Select "Chemicals" in the industry drop down
		WebElement Industry = driver.findElement(By.name("industry"));
		Select select=new Select(Industry);
		select.selectByVisibleText("Chemicals");
	//Save and Verify
//	logout of Application
	}

}
