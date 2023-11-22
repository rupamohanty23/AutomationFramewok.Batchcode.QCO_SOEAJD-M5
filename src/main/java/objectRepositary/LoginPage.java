package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1
	//Declaration
	@FindBy(name="user_name")
	  private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	//Initialization
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Business Library-->Generic method using the webElements in current
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD 
	 */
	public void loginToApp(String USERNAME,String PASSWORD )
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	

}
