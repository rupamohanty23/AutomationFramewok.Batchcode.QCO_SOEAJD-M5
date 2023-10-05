package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sceneario1 {
	public static void main(String[] args) throws InterruptedException {
		//step1:Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//it waits all the pages to be loaded
		
		driver.get("http://localhost:8888/");
		
		//step 2: Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step 3:navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		//step 4:click on create contact lookup image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//step 5:create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Rupa");
		//step 6:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//step 7:Validate
	 String contactHeader	=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	 if(contactHeader.contains("Rupa")) {
		 System.out.println(contactHeader);
		 System.out.println("pass");
	 }
	 else {
		 System.out.println("fail");
	 }
		//step 8:Logout
	 WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act=new Actions(driver) ;
	 act.moveToElement(ele).perform();
	 Thread.sleep(1000);
	 driver.findElement(By.linkText("Sign Out")).click();
	 System.out.println("Logout is successful");
	 
	 
	}

}
