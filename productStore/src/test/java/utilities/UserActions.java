package utilities;

import org.openqa.selenium.By;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserActions {
	
	public void navigateTo(WebDriver driver, String navigateToElement)
	{
		By navigateToElementXpath = By.xpath("//a[contains(text(),'" +navigateToElement + "')]");
		WebElement navigateTo = driver.findElement(navigateToElementXpath);
		navigateTo.click();
	}
	
	public void waitforElement (WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForElementToBePresent (WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitforAlert (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	

}
