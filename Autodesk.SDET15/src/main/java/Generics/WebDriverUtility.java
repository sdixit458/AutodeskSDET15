package Generics;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class contains generics method of all webdriver actions
 * @author Saurabh
 *
 */
public class WebDriverUtility {
	/**
	 * This method will select the value a value from drop down on base of text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will select the value a value from drop down on base of index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will perform mouse over action
	 * @param driver
	 * @param target
	 */
	public void mouseOver(WebDriver driver, WebElement target) {
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();
	}
	/**
	 * This method will perform
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * this method use for maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is webdriver implicitly wait for page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * Explicitly wait for an element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method helps to switch one window to another window
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext()) {
			String winID = it.next();
			String title = driver.switchTo().window(winID).getTitle();
			if(title.contains(partialWinTitle)) {
				break;
			}
		}
	}
	/**
	 * This method use to accept popUp
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method use to dissmis popUp
	 * @param driver
	 */
	public void dissmisAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * Switch to frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * Switch to frame based on Index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * Switch to frame based on id or name
	 * @param driver
	 * @param IdOrName
	 */
	public void switchToFrame(WebDriver driver,String IdOrName) {
		driver.switchTo().frame(IdOrName);
	}
	/**
	 * It will take screenShot
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public void takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src, dest);
	}
	/**
	 * This will scroll to a paticular webElement
	 * @param driver
	 * @param element
	 */
	public void scrollToWebelement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	/**
	 * This method use for key Enter
	 * @throws Throwable
	 */
	public void pressEnter() throws Throwable {
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
