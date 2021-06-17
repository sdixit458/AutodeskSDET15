package Autodesk.Autodesk.SDET15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInformationPage {
	
	public OrganisationInformationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organisationInfo;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryInfo;

	/**
	 * @return the organisationInfo
	 */
	public WebElement getOrganisationInfo() {
		return organisationInfo;
	}

	/**
	 * @return the industryInfo
	 */
	public WebElement getIndustryInfo() {
		return industryInfo;
	}
	
	public String getOrganisationText()
	{
		return organisationInfo.getText();
	}
	
	public String getIndusInfo()
	{
		return industryInfo.getText();
	}

}
