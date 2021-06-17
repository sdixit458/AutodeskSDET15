package Autodesk.Autodesk.SDET15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generics.WebDriverUtility;

public class CreateOrganisationPage extends WebDriverUtility{
	
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organisationName;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	/**
	 * @return the organisationName
	 */
	public WebElement getOrganisationName() {
		return organisationName;
	}

	/**
	 * @return the industryDropdown
	 */
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrganisation(String orgName)
	{
		organisationName.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrganisationWithIndustry(String orgName, String indType)
	{
		organisationName.sendKeys(orgName);
	    select(industryDropdown, indType);
		saveBtn.click();
	}

}
