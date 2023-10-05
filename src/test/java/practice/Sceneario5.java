package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sceneario5 {
	public static void main(String[] args) throws InterruptedException {
//		Launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		
//		Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
//		Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
//		Click on Create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//		Create contact with manadatory fields
		driver.findElement(By.name("lastname")).sendKeys("Rupa");
		//click on Org lookup image
		driver.findElement(By.xpath("//img[@alt='Select'][1]")).click();
		//capture the main/parent windowid
		String mainWindowID = driver.getWindowHandle();
		System.out.println(mainWindowID +"--main window ID");
		//capture all the capture windowids-main and child
		Set<String> allWindowIDS = driver.getWindowHandles();
		
		//compare and switch to child window
		for(String winID:allWindowIDS) {
			if(!winID.equals(mainWindowID)) {
				System.out.println(winID+"--child window ID");
				driver.switchTo().window(winID);
				System.out.println("switched to child");
				break;
				
			}
		}
		//search for Organization
		driver.findElement(By.name("search_text")).sendKeys("ABC");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("ABC")).click();
		
		//switch the control back to parent
		driver.switchTo().window(mainWindowID);
		System.out.println("switched back to parent");
		
		//		Save 
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("Rupa")) {
			System.out.println(contactHeader);
			System.out.println("pass");
		}
		else {
			System.out.println("Fail");
		}
		
        //logout 
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
         Actions action =new Actions(driver);
         action.moveToElement(ele).perform();
         Thread.sleep(1000);
         driver.findElement(By.linkText("Sign Out")).click();
         System.out.println("Logout is successful");
	}

}
