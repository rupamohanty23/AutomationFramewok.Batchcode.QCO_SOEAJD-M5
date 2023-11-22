package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
   //utilization

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
   //Business Library
	/**
	 * This method will create new organization with mandatory fields
	 * @param orgname
	 */
	public void createNewOrganization(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
		
	}

	
	
	
	}

