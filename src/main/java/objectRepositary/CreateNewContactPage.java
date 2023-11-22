package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//img[@alt='Select'][1]")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//Utilization

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	//Business Library
	/**
	 * This method will create contact with mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create contact by choosing the organization
	 * @param driver
	 * @param ORGNAME
	 * @param LASTNAme
	 */
	public void createNewContact(WebDriver driver,String ORGNAME,String LASTNAME) {
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		
		
		
		
	}

}
