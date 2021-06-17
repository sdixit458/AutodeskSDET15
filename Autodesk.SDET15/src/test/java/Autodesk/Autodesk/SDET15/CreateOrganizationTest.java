package Autodesk.Autodesk.SDET15;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generics.BaseClass;

@Listeners(Generics.ListnerImplimentation.class)
public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups = "SmokeTest")
	public void createOrgTest() throws Throwable
	{		
		//fetch the data
		String OrgName = eLib.getExcelData("sheet1","TC_01","OrgName")+jLib.getRandomNumber();
		
	    //navigate to organizations
	    driver.findElement(By.linkText("Organizations")).click();
	    
	    //navigate to create organization
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    
	    //enter mandatory fields and create organization
	    driver.findElement(By.name("accountname")).sendKeys(OrgName);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //validate
        String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        Assert.assertTrue(successMsg.contains(OrgName));
        System.out.println(successMsg);
        System.out.println("Done");
        
        //Logout
        driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();
      	driver.findElement(By.linkText("Sign Out")).click();
	}
	
	@Test
	public void createOrgWithType()
	{
		System.out.println("organization created");
	}
	

}
