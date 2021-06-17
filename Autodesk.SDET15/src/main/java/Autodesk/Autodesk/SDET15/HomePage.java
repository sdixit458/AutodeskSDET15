package Autodesk.Autodesk.SDET15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generics.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organisationLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorIMG;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	 @FindBy(linkText = "Contacts")
	  private WebElement contactsLnk;
	  
	  @FindBy(linkText = "Opportunities")
	  private WebElement opportunitiesLnk;
	  
	  @FindBy(linkText = "Products")
	  private WebElement productsLnk;
	  
	  @FindBy(linkText = "Leads")
	  private WebElement leadsLnk;
	  
	  @FindBy(linkText = "More")
	  private WebElement moreLnk;
	  
	  @FindBy(linkText = "Purchase Order")
	  private WebElement purchaseOrderLnk;

	/**
	 * @return the organisationLink
	 */
	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	/**
	 * @return the adminstratorIMG
	 */
	public WebElement getAdminstratorIMG() {
		return adminstratorIMG;
	}

	/**
	 * @return the signOutLink
	 */
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public WebElement getmoreLnk() {
		return moreLnk;
	}

	public WebElement getpurchaseOrderLnk()
	{
		return purchaseOrderLnk;
	}
	
	/**
	 * This method is used to click on Organisation Link
	 */
	public void clickOnOrganisationLink() {
		organisationLink.click();
	}
	
	public void navigateContacts()
	{
		contactsLnk.click();
	}

	public void navigateMore()
	{
		moreLnk.click();
		mouseOver(driver, moreLnk);
	}
	
	public void signOut() {
		mouseOver(driver, adminstratorIMG);
		signOutLink.click();
	}

}
