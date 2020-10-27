package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.*;

public class HomeScreen {
	
	
	
	UserActions action = new UserActions();
	
	
	
	public void launchWebsite (WebDriver driver, String websiteURL)
	{
		driver.get(websiteURL);
	}

	public void navigateToCategory(WebDriver driver, String categoryName)
	{
		action.navigateTo(driver, categoryName);
	}
	
	public void selectProduct(WebDriver driver, String productName) 
	{
	
		By productXpath = By.xpath("//a[contains(text(),'"+ productName + "')]");
		action.waitforElement(driver, productXpath);
		WebElement product = driver.findElement(productXpath);
		product.click();
	}
	
	public void navigateToCart(WebDriver driver, String cart)
	{
		action.navigateTo(driver, cart);
	}
	
	
	
	
	

}
